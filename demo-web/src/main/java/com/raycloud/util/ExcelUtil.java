/*
package com.cn.controller;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

*/
/**
 * Excel工具类
 * Created by daixiaoming on 2017/2/10.
 *//*

public final class ExcelUtil {

    private ExcelUtil() {
    }

    */
/**
     * 创建Excel带title对象
     *//*

    public static HSSFWorkbook createHSSFWorkbook(List<String> titles) throws IOException {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet sheet = hssfWorkbook.createSheet("sheet1");
        HSSFRow row = sheet.createRow(0);
        int cellId = 0;
        for(String title: titles){
            HSSFCell cell = row.createCell(cellId++);
            cell.setCellValue(title);
        }
        return hssfWorkbook;
    }

    */
/**
     * 根据模板创建Excel对象
     *//*

    public static HSSFWorkbook createHSSFWorkbook(String templatePath) throws IOException {
        InputStream is = null;
        try {
            is = new FileInputStream(templatePath);
            POIFSFileSystem poifsFileSystem = new POIFSFileSystem(is);
            return new HSSFWorkbook(poifsFileSystem);
        } finally {
            IOUtils.closeQuietly(is);
        }
    }

    */
/**
     * 把文件转换成excel对象
     *//*

    public static Workbook convertToWorkbook(File tempFile) throws IOException, InvalidFormatException {
        return WorkbookFactory.create(tempFile);
    }

    */
/**
     * 填充excel数据
     *//*

    public static HSSFWorkbook fillExcelData(HSSFWorkbook workbook, List<RowModel> dataList) {
        if (workbook == null) {
            return null;
        }

        //读取excel模板
        HSSFSheet sheet = workbook.getSheetAt(0);
        int rowIndex = 1;
        for (RowModel rowModel : dataList) {

            List<List<String>> multiCellList = rowModel.getMultiCellList();
            if (CollectionUtils.isEmpty(multiCellList)) {  //没有多行合并的情况
                //处理每一行
                HSSFRow row = sheet.createRow(rowIndex);
                int cellIndex = 0;
                for (String value : rowModel.getCellList()) {
                    HSSFCell cell = row.createCell(cellIndex);
                    cell.setCellValue(value);
                    cellIndex++;
                }
                rowIndex++;
            } else {  //处理存在多行合并的情况
                //处理每一行
                int cellIndex;
                int multiHeightSize = multiCellList.size();
                List<String> cellValList = rowModel.getCellList();
                int firstPartSize = CollectionUtils.isNotEmpty(cellValList) ? cellValList.size() : 0;
                //先处理多行
                HSSFRow row;
                for (List<String> rowDataList : multiCellList) {
                    row = sheet.createRow(rowIndex);
                    //处理每一行
                    cellIndex = firstPartSize;
                    for (String value : rowDataList) {
                        HSSFCell cell = row.createCell(cellIndex);
                        cell.setCellValue(value);
                        cellIndex++;
                    }
                    rowIndex++;
                }

                if (CollectionUtils.isNotEmpty(cellValList)) {
                    //再处理单行
                    cellIndex = 0;
                    int startRowIndex = rowIndex - multiHeightSize;
                    HSSFRow startRow = sheet.getRow(startRowIndex);
                    for (String value : cellValList) {
                        HSSFCell cell = startRow.createCell(cellIndex);
                        cell.setCellValue(value);
                        sheet.addMergedRegion(new CellRangeAddress(startRowIndex, rowIndex - 1, cellIndex, cellIndex));
                        cellIndex++;
                    }
                }
            }
        }

        return workbook;
    }

}
*/
