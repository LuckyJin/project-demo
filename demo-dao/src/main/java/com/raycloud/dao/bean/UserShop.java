package com.cn.dao.bean;

import java.util.*;
import java.math.BigDecimal;

/**
 * Created by baomingfeng at 2017-12-07 10:22:33
 */
public class UserShop  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/*shopping_id*/
    private Integer shoppingId;

	/*price*/
    private BigDecimal price;

	/*count*/
    private Integer count;

	/*商品类型*/
    private Integer type;

	/*user_id*/
    private Integer userId;



    public Integer getShoppingId() {
       return shoppingId;
    }

    public void setShoppingId(Integer shoppingId) {
       this.shoppingId = shoppingId;
    }

    public BigDecimal getPrice() {
       return price;
    }

    public void setPrice(BigDecimal price) {
       this.price = price;
    }

    public Integer getCount() {
       return count;
    }

    public void setCount(Integer count) {
       this.count = count;
    }

    public Integer getType() {
       return type;
    }

    public void setType(Integer type) {
       this.type = type;
    }

    public Integer getUserId() {
       return userId;
    }

    public void setUserId(Integer userId) {
       this.userId = userId;
    }

}