/*
package com.raycloud.controller;

import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

*/
/**
 * 下载工具类
 * Created by daixiaoming on 2017/1/21.
 *//*

public class DownloadUtil {

    */
/**
     * 输出excel数据
     *//*

    public static void downExcel(HttpServletResponse response, String fileName, List<String> titles, List<RowModel> dataList) throws Exception {
        HSSFWorkbook workbook;

        workbook = ExcelUtil.createHSSFWorkbook(titles);

        ExcelUtil.fillExcelData(workbook, dataList);

        downExcelForNoModel(response, workbook, fileName);
    }


    */
/**
     * 输出excel数据
     *//*

    private static void downExcel(HttpServletResponse response, HSSFWorkbook workbook, String fileName) throws Exception {
        OutputStream os = null;
        try {
            response.reset();
            // 编码处理，对于操作系统 （ linux默认 utf-8,windows 默认 GBK)
            String defaultEncoding = System.getProperty("file.encoding");
            if (defaultEncoding != null && defaultEncoding.equals("UTF-8")) {
                response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("GBK"), "iso-8859-1"));
            } else {
                response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "iso-8859-1"));
            }

            // 设置response的Header
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");

            os = response.getOutputStream();
            workbook.write(os);
            long len = workbook.getBytes().length;
            response.addHeader("Content-Length", String.valueOf(len));
            os.flush();
        } finally {
            IOUtils.closeQuietly(os);
        }
    }

    private static void downExcelForNoModel(HttpServletResponse response, HSSFWorkbook workbook, String fileName) throws Exception {
        BufferedInputStream bis = null;
        BufferedOutputStream os = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            workbook.write(bos);
            byte[] content = bos.toByteArray();
            InputStream is = new ByteArrayInputStream(content);
            response.reset();
            // 编码处理，对于操作系统 （ linux默认 utf-8,windows 默认 GBK)
            String defaultEncoding = System.getProperty("file.encoding");
            if (defaultEncoding != null && defaultEncoding.equals("UTF-8")) {
                response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("GBK"), "iso-8859-1"));
            } else {
                response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "iso-8859-1"));
            }

            // 设置response的Header
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            bis = new BufferedInputStream(is);
            os = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                os.write(buff, 0, bytesRead);
            }
        } finally {
            if (bis != null)
                bis.close();
            if (os != null)
                os.close();
        }
    }

}
*/
