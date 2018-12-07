package com.cn.dao.bean;

import java.util.*;

/**
 * Created by baomingfeng at 2017-12-14 03:41:53
 */
public class AutoDeliveryJob  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/*id*/
    private Integer id;

	/*taobao_id*/
    private Long taobaoId;

	/*exc_time*/
    private Integer excTime;

	/*filter_tids*/
    private String filterTids;

	/*create_time*/
    private Date createTime;



    public Integer getId() {
       return id;
    }

    public void setId(Integer id) {
       this.id = id;
    }

    public Long getTaobaoId() {
       return taobaoId;
    }

    public void setTaobaoId(Long taobaoId) {
       this.taobaoId = taobaoId;
    }

    public Integer getExcTime() {
       return excTime;
    }

    public void setExcTime(Integer excTime) {
       this.excTime = excTime;
    }

    public String getFilterTids() {
       return filterTids;
    }

    public void setFilterTids(String filterTids) {
       this.filterTids = filterTids;
    }

    public Date getCreateTime() {
       return createTime;
    }

    public void setCreateTime(Date createTime) {
       this.createTime = createTime;
    }

}