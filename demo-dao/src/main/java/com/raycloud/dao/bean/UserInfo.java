package com.cn.dao.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

/**
 * Created by baomingfeng at 2017-12-07 10:22:33
 */
public class UserInfo  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/*用户Id*/
    private Long userId;


	/*淘宝Id*/
    private Long taobaoId;

	/*淘宝nick*/
    private String taobaoNick;

	/*会话Id*/
    private String sessionId;

	/*淘宝店铺Id*/
    private Long shopId;

	/*淘宝店铺类目*/
    private Long shopCid;

	/*淘宝店铺类型 */
    private String shopType;

	/*店长用户等级*/
    private Integer dzVipLevel;


	/*创建时间*/
    private Date gmtCreated;

	/*更新时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date gmtModified;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTaobaoId() {
        return taobaoId;
    }

    public void setTaobaoId(Long taobaoId) {
        this.taobaoId = taobaoId;
    }



    public String getTaobaoNick() {
       return taobaoNick;
    }

    public void setTaobaoNick(String taobaoNick) {
       this.taobaoNick = taobaoNick;
    }


    public Long getShopId() {
       return shopId;
    }

    public void setShopId(Long shopId) {
       this.shopId = shopId;
    }

    public Long getShopCid() {
       return shopCid;
    }

    public void setShopCid(Long shopCid) {
       this.shopCid = shopCid;
    }

    public String getShopType() {
       return shopType;
    }

    public void setShopType(String shopType) {
       this.shopType = shopType;
    }

    public Integer getDzVipLevel() {
       return dzVipLevel;
    }

    public void setDzVipLevel(Integer dzVipLevel) {
       this.dzVipLevel = dzVipLevel;
    }


    public Date getGmtCreated() {
       return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
       this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
       return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
       this.gmtModified = gmtModified;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}