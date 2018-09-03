package com.cn.dao.bean;

import java.util.*;

/**
 * Created by baomingfeng at 2017-12-15 09:01:43
 */
public class OrderInfo  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/*oid*/
    private Long oid;

	/*tid*/
    private Long tid;

	/*seller_nick*/
    private String sellerNick;

	/*buyer_nick*/
    private String buyerNick;

	/*num_iid*/
    private Long numIid;

	/*total_fee*/
    private String totalFee;

	/*discount_fee*/
    private String discountFee;

	/*payment*/
    private String payment;

	/*modified*/
    private Date modified;

	/*status*/
    private String status;

	/*sku_properties_name*/
    private String skuPropertiesName;

	/*num*/
    private Long num;

	/*title*/
    private String title;

	/*price*/
    private String price;

	/*pic_path*/
    private String picPath;

	/*outer_iid*/
    private String outerIid;

	/*outer_sku_id*/
    private String outerSkuId;

	/*item_meal_name*/
    private String itemMealName;

	/*refund_status*/
    private String refundStatus;

	/*main_tid*/
    private Long mainTid;

	/*oid_bak*/
    private Long oidBak;

	/*logistics_company*/
    private String logisticsCompany;

	/*invoice_no*/
    private String invoiceNo;

	/*consign_time*/
    private Date consignTime;

	/*sku_id*/
    private String skuId;



    public Long getOid() {
       return oid;
    }

    public void setOid(Long oid) {
       this.oid = oid;
    }

    public Long getTid() {
       return tid;
    }

    public void setTid(Long tid) {
       this.tid = tid;
    }

    public String getSellerNick() {
       return sellerNick;
    }

    public void setSellerNick(String sellerNick) {
       this.sellerNick = sellerNick;
    }

    public String getBuyerNick() {
       return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
       this.buyerNick = buyerNick;
    }

    public Long getNumIid() {
       return numIid;
    }

    public void setNumIid(Long numIid) {
       this.numIid = numIid;
    }

    public String getTotalFee() {
       return totalFee;
    }

    public void setTotalFee(String totalFee) {
       this.totalFee = totalFee;
    }

    public String getDiscountFee() {
       return discountFee;
    }

    public void setDiscountFee(String discountFee) {
       this.discountFee = discountFee;
    }

    public String getPayment() {
       return payment;
    }

    public void setPayment(String payment) {
       this.payment = payment;
    }

    public Date getModified() {
       return modified;
    }

    public void setModified(Date modified) {
       this.modified = modified;
    }

    public String getStatus() {
       return status;
    }

    public void setStatus(String status) {
       this.status = status;
    }

    public String getSkuPropertiesName() {
       return skuPropertiesName;
    }

    public void setSkuPropertiesName(String skuPropertiesName) {
       this.skuPropertiesName = skuPropertiesName;
    }

    public Long getNum() {
       return num;
    }

    public void setNum(Long num) {
       this.num = num;
    }

    public String getTitle() {
       return title;
    }

    public void setTitle(String title) {
       this.title = title;
    }

    public String getPrice() {
       return price;
    }

    public void setPrice(String price) {
       this.price = price;
    }

    public String getPicPath() {
       return picPath;
    }

    public void setPicPath(String picPath) {
       this.picPath = picPath;
    }

    public String getOuterIid() {
       return outerIid;
    }

    public void setOuterIid(String outerIid) {
       this.outerIid = outerIid;
    }

    public String getOuterSkuId() {
       return outerSkuId;
    }

    public void setOuterSkuId(String outerSkuId) {
       this.outerSkuId = outerSkuId;
    }

    public String getItemMealName() {
       return itemMealName;
    }

    public void setItemMealName(String itemMealName) {
       this.itemMealName = itemMealName;
    }

    public String getRefundStatus() {
       return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
       this.refundStatus = refundStatus;
    }

    public Long getMainTid() {
       return mainTid;
    }

    public void setMainTid(Long mainTid) {
       this.mainTid = mainTid;
    }

    public Long getOidBak() {
       return oidBak;
    }

    public void setOidBak(Long oidBak) {
       this.oidBak = oidBak;
    }

    public String getLogisticsCompany() {
       return logisticsCompany;
    }

    public void setLogisticsCompany(String logisticsCompany) {
       this.logisticsCompany = logisticsCompany;
    }

    public String getInvoiceNo() {
       return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
       this.invoiceNo = invoiceNo;
    }

    public Date getConsignTime() {
       return consignTime;
    }

    public void setConsignTime(Date consignTime) {
       this.consignTime = consignTime;
    }

    public String getSkuId() {
       return skuId;
    }

    public void setSkuId(String skuId) {
       this.skuId = skuId;
    }

}