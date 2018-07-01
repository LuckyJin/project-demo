package com.raycloud.util.vo;

import java.io.Serializable;
import java.util.List;

/**
 * excel行模型
 */
public class RowModel implements Serializable {

    /**
     * 单行
     */
    private List<String> cellList;
    /**
     * 多行
     */
    private List<List<String>> multiCellList;

    public List<String> getCellList() {
        return cellList;
    }

    public void setCellList(List<String> cellList) {
        this.cellList = cellList;
    }

    public List<List<String>> getMultiCellList() {
        return multiCellList;
    }

    public void setMultiCellList(List<List<String>> multiCellList) {
        this.multiCellList = multiCellList;
    }
}
