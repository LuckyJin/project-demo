package com.raycloud.dao.bean;

import java.util.*;

/**
 * Created by baomingfeng at 2018-06-28 07:05:27
 */
public class User  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /*id*/
    private Long id;

    /*username*/
    private String username;

    /*pwd*/
    private String pwd;

    /*phone*/
    private String phone;

    /*created*/
    private Date created;

    /*modified*/
    private Date modified;

    /*user_id*/
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}