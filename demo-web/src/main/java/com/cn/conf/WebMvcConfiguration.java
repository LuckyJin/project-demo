package com.cn.conf;


import com.cn.springmvc.StringToDateConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.lang.reflect.Field;

@Configuration
@EnableWebMvc
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {


    /**
     * 补充通用的String转Date转换器
     */
    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {
        formatterRegistry.addConverter(new StringToDateConverter());
    }

    private static final String[] ENCRYPT_FIELD_NAME = new String[]{"name", "phone"};

    static class Test {
        private String name;

        private String phone;

        public Test(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "Test{" +
                    "name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }

    public static void encryptObject(Object object) {
        for (String fieldName : ENCRYPT_FIELD_NAME) {
            try {
                Field field = object.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                String str = field.get(object).toString();
                String encryptStr = encrypt(str);
                field.set(object, encryptStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String encrypt(String str) {
        //这里可以调用远程服务对指定的字符串加密
        //return Md5Encrypt.md5(str);
        return str;
    }

    public static void main(String[] args) {
        Test test = new Test("stupid", "110");
        System.out.println(test.toString());
        encryptObject(test);
        System.out.println(test.toString());
    }


}