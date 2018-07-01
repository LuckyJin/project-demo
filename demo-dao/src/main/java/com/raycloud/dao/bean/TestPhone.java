package com.raycloud.dao.bean;

import java.util.*;

/**
 * Created by baomingfeng at 2017-12-05 03:44:40
 */
public class TestPhone  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/*id*/
    private Integer id;

	/*phone*/
    private String phone;



    public Integer getId() {
       return id;
    }

    public void setId(Integer id) {
       this.id = id;
    }

    public String getPhone() {
       return phone;
    }

    public void setPhone(String phone) {
       this.phone = phone;
    }

}