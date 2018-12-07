package com.cn.dao.bean;

import java.util.*;

/**
 * Created by baomingfeng at 2017-12-07 10:22:33
 */
public class UserOrder  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/*order_id*/
    private Integer orderId;

	/*user_id*/
    private Integer userId;

	/*shop_id*/
    private Integer shopId;



    public Integer getOrderId() {
       return orderId;
    }

    public void setOrderId(Integer orderId) {
       this.orderId = orderId;
    }

    public Integer getUserId() {
       return userId;
    }

    public void setUserId(Integer userId) {
       this.userId = userId;
    }

    public Integer getShopId() {
       return shopId;
    }

    public void setShopId(Integer shopId) {
       this.shopId = shopId;
    }

}