package com.raycloud.service.common.page;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by baomingfeng at 2017-09-19 14:13:33
 */
public abstract class PageQuery
        implements java.io.Serializable {

    @NotNull
    @Min(1L)
    private Integer pageNo = 1;

    @NotNull
    @Range(min = 1L, max = 50L)
    private Integer pageSize = 20;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
