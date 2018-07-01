package com.raycloud.service.common.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Pattern;

/**
 * Created by baomingfeng at 2017-09-06 11:24:40
 */
public class EnvUtils {
    private final static Log LOG = LogFactory.getLog(EnvUtils.class);

    private final static String META_INF_MAVEN = "META-INF" + File.separatorChar + "maven" + File.separatorChar;

    /*
    public static void main(String[] args) throws Exception {
        Properties pom = new Properties();
        URL dirURL = new URL("jar:file:/Users/baomingfeng/prj/spring-boot-demo-2-1/target/spring-boot-demo-2-1-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/slf4j-api-1.7.21.jar!/org/slf4j/Logger.class");
        String META_INF_MAVEN = "META-INF" + File.separatorChar + "maven" + File.separatorChar;
        String path = dirURL.getPath();
        String jarPath = path.substring(5, dirURL.getPath().indexOf("!"));
        //String jarPath = dirURL.getPath().substring(5, dirURL.getPath().indexOf("!")); //strip out only the JAR file
        JarFile jar = new JarFile(new File(jarPath));
        Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
        ArrayList<JarEntry> result = new ArrayList<JarEntry>(); //avoid duplicates in case it is a subdirectory
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            String name = entry.getName();
            //META-INF/maven/xxx/xxx/pom.properties
            if (name.startsWith(META_INF_MAVEN)
                    && name.endsWith("pom.properties")) {
                String entryName = name.substring(META_INF_MAVEN.length());
                if (countMatches(entryName, '/') == 2) {
                    result.add(entry);
                }
            }
        }

        if (result.size() == 1) {
            JarEntry jarEntry = result.get(0);
            InputStream inputStream = jar.getInputStream(jarEntry);
            try {
                pom.load(inputStream);
            } finally {
                close(inputStream);
            }
        }
        System.out.println(pom);

        File searchDir = new File("/Users/baomingfeng/prj/remote-debug/target/remote-debug/META-INF/maven");
        List<File> files = searchSpecificDepthFiles(searchDir, "pom.properties", 3);
        System.out.println(files);
    }
    */

    /**
     * 默认从application name从maven打包的pom.properties文件中读出来（目前只支持maven工程）
     */
    public static Properties lookupPomInfo() {
        Properties pom = new Properties();
        ClassLoader loader = EnvUtils.class.getClassLoader();
        URL loaderUrl = loader.getResource("");//获取目录

        if (loaderUrl == null) {
            LOG.error("cannot read 'pom.properties', because of ClassLoader.getResource(\"\") return null. ");
            return pom;
        }

        if (loaderUrl.getProtocol().equals("file")) {
            /* A file path: easy enough */
            loadDirectoryPom(pom, loaderUrl);
        } else if (loaderUrl.getProtocol().equals("jar")) {
            loadJarPom(pom);
        }

        return pom;
    }

    public static void loadDirectoryPom(Properties pom, URL loaderUrl) {
        String path = loaderUrl.getPath();
        int mark = path.indexOf("WEB-INF");//war  archive
        if (mark < 0) {
            LOG.warn("cannot read 'pom.properties' from file, because of path: " + path);
        }
        String rootDir = path.substring(0, mark);
        String dirStr = buildPath(rootDir, META_INF_MAVEN);
        final File searchDir = new File(dirStr);
        if (searchDir.exists() && searchDir.isDirectory()) {
            List<File> files = searchSpecificDepthFiles(searchDir, "pom.properties", 2);
            if (files.size() > 0) {
                if (files.size() > 1) {
                    LOG.warn("cannot read 'pom.properties' from file, because of more than one files found: " + files);
                }
                File pomFile = files.get(0);
                try {
                    loadProperties(pom, new FileInputStream(pomFile));
                } catch (IOException ioe) {
                    LOG.warn("cannot read 'pom.properties' from file, because of : " + ioe.getMessage(), ioe);
                }
            }
        }
    }

    /**
     * List directory contents for a resource folder. Not recursive.
     * This is basically a brute-force implementation.
     * Works for regular JARs.
     */
    public static void loadJarPom(Properties pom) {
        /*
         * In case of a jar file, we can't actually find a directory.
         * Have to assume the same jar as clazz.
         */
        String me = EnvUtils.class.getName().replace(".", "/") + ".class";
        URL dirURL = EnvUtils.class.getClassLoader().getResource(me);

        if (dirURL == null) {
            LOG.error("cannot read 'pom.properties' from jar, because of ClassLoader.getResource(\"" + me + "\") return null. ");
            return;
        }

        String path = dirURL.getPath();
        String jarPath = path.substring(5, path.indexOf("!")); //strip out only the JAR file
        JarFile jar = getJarFile(jarPath);
        Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
        ArrayList<JarEntry> result = new ArrayList<JarEntry>(); //avoid duplicates in case it is a subdirectory
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            String name = entry.getName();
            //META-INF/maven/xxx/xxx/pom.properties
            if (name.startsWith(META_INF_MAVEN)
                    && name.endsWith("pom.properties")) {
                String entryName = name.substring(META_INF_MAVEN.length());
                if (countMatches(entryName, '/') == 2) {
                    result.add(entry);
                }
            }
        }

        if (result.size() == 1) {
            JarEntry jarEntry = result.get(0);
            try {
                loadProperties(pom, jar.getInputStream(jarEntry));
            } catch (IOException ioe) {
                LOG.warn("cannot read 'pom.properties' from jar, because of : " + ioe.getMessage(), ioe);
            }
        }
    }

    private static class SpecificDepthFileSearch {
        private File searchDir;
        private String name;
        private int specificDepth;

        private int depthCount;
        private List<File> result = new ArrayList<File>();

        public SpecificDepthFileSearch(File searchDir, String name, int specificDepth) {
            this.searchDir = searchDir;
            this.name = name;
            this.specificDepth = specificDepth;
        }

        void search() {
            _search(searchDir);
        }

        private void _search(File dir) {
            //do you have permission to read this directory?
            if (dir.canRead()) {
                File[] files = dir.listFiles();
                if (files != null) {
                    for (File temp : files) {
                        if (temp.isDirectory()) {
                            if (depthCount < specificDepth) {
                                depthCount++;
                                _search(temp);
                            }
                        } else {
                            if (depthCount == specificDepth
                                    && name.equalsIgnoreCase(temp.getName())) {
                                result.add(temp);
                            }
                        }
                    }
                }
                depthCount--;
            }
        }

        List<File> getResult() {
            return result;
        }
    }

    /**
     * 搜索目录下指定深度下的文件
     *
     * @param dir           目标目录
     * @param fileName      文件名
     * @param specificDepth 目录深度，如specificDepth=2，只会搜索二级目录下的文件
     */
    public static List<File> searchSpecificDepthFiles(File dir, String fileName, int specificDepth) {
        SpecificDepthFileSearch fileSearch = new SpecificDepthFileSearch(dir, fileName, specificDepth);
        fileSearch.search();
        return fileSearch.getResult();
    }

    public static void loadProperties(
            Properties prop, InputStream inputStream) throws IOException {
        try {
            prop.load(inputStream);
        } finally {
            close(inputStream);
        }
    }

    public static JarFile getJarFile(String jarPath) {
        try {
            return new JarFile(URLDecoder.decode(jarPath, "UTF-8"));
        } catch (IOException ioe) {
            throw new IllegalStateException(ioe);
        }
    }

    public static String buildPath(String dir, String file) {
        if (dir == null) {
            return file;
        }
        if (dir.endsWith(File.separator)) {
            return dir + file;
        }
        return dir + File.separator + file;
    }

    public static int countMatches(String str, char ch) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int count = 0;
        // We could also call str.toCharArray() for faster look ups but that would generate more garbage.
        for (int i = 0; i < str.length(); i++) {
            if (ch == str.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException ignored) {
            }
        }
    }

    /* ============================== */

    /*com.alibaba.dubbo.common.utils.NetUtils*/
    private static volatile InetAddress LOCAL_ADDRESS = null;

    public static final String LOCALHOST = "127.0.0.1";

    /**
     * 遍历本地网卡，返回第一个合理的IP。
     *
     * @return 本地网卡IP
     */
    public static InetAddress getLocalAddress() {
        if (LOCAL_ADDRESS != null)
            return LOCAL_ADDRESS;
        InetAddress localAddress = getLocalAddress0();
        LOCAL_ADDRESS = localAddress;
        return localAddress;
    }

    public static String getLogHost() {
        InetAddress address = LOCAL_ADDRESS;
        return address == null ? LOCALHOST : address.getHostAddress();
    }

    private static InetAddress getLocalAddress0() {
        InetAddress localAddress = null;
        try {
            localAddress = InetAddress.getLocalHost();
            if (isValidAddress(localAddress)) {
                return localAddress;
            }
        } catch (Throwable e) {
            LOG.warn("Failed to retriving ip address, " + e.getMessage(), e);
        }
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            if (interfaces != null) {
                while (interfaces.hasMoreElements()) {
                    try {
                        NetworkInterface network = interfaces.nextElement();
                        Enumeration<InetAddress> addresses = network.getInetAddresses();
                        while (addresses.hasMoreElements()) {
                            try {
                                InetAddress address = addresses.nextElement();
                                if (isValidAddress(address)) {
                                    return address;
                                }
                            } catch (Throwable e) {
                                LOG.warn("Failed to retriving ip address, " + e.getMessage(), e);
                            }
                        }
                    } catch (Throwable e) {
                        LOG.warn("Failed to retriving ip address, " + e.getMessage(), e);
                    }
                }
            }
        } catch (Throwable e) {
            LOG.warn("Failed to retriving ip address, " + e.getMessage(), e);
        }
        LOG.warn("Could not get local host ip address, will use 127.0.0.1 instead.");
        return localAddress;
    }

    private static final Pattern IP_PATTERN = Pattern.compile("\\d{1,3}(\\.\\d{1,3}){3,5}$");

    public static final String ANYHOST = "0.0.0.0";

    private static boolean isValidAddress(InetAddress address) {
        if (address == null || address.isLoopbackAddress())
            return false;
        String name = address.getHostAddress();
        return (name != null
                && !ANYHOST.equals(name)
                && !LOCALHOST.equals(name)
                && IP_PATTERN.matcher(name).matches());
    }
}
