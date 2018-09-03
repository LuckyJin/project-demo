package com.cn.dao.bean;

import java.util.*;

/**
 * Created by baomingfeng at 2017-12-15 09:01:43
 */
public class TradeInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/*tid*/
    private Long tid;

	/*title*/
    private String title;

	/*price*/
    private Float price;

	/*seller_nick*/
    private String sellerNick;

	/*buyer_nick*/
    private String buyerNick;

	/*modified*/
    private Date modified;

	/*created*/
    private Date created;

	/*status*/
    private String status;

	/*type*/
    private String type;

	/*shipping_type*/
    private String shippingType;

	/*num*/
    private Long num;

	/*payment*/
    private String payment;

	/*discount_fee*/
    private String discountFee;

	/*trade_memo*/
    private String tradeMemo;

	/*seller_memo*/
    private String sellerMemo;

	/*buyer_message*/
    private String buyerMessage;

	/*buyer_email*/
    private String buyerEmail;

	/*total_fee*/
    private Float totalFee;

	/*post_fee*/
    private Float postFee;

	/*receiver_name*/
    private String receiverName;

	/*receiver_state*/
    private String receiverState;

	/*receiver_city*/
    private String receiverCity;

	/*receiver_district*/
    private String receiverDistrict;

	/*receiver_address*/
    private String receiverAddress;

	/*receiver_zip*/
    private String receiverZip;

	/*receiver_mobile*/
    private String receiverMobile;

	/*receiver_phone*/
    private String receiverPhone;

	/*printed_kuaidi*/
    private Integer printedKuaidi;

	/*printed_fahuo*/
    private Integer printedFahuo;

	/*merge_tid*/
    private Long mergeTid;

	/*yd_id*/
    private String ydId;

	/*wuliu*/
    private String wuliu;

	/*remark*/
    private String remark;

	/*pay_time*/
    private Date payTime;

	/*print_fahuo_time*/
    private Date printFahuoTime;

	/*print_kuaidi_time*/
    private Date printKuaidiTime;

	/*fahuo_time*/
    private Date fahuoTime;

	/*trade_gift*/
    private String tradeGift;

	/*invoice_name*/
    private String invoiceName;

	/*is_elec*/
    private Integer isElec;

	/*service_tag*/
    private String serviceTag;

	/*是否已打印配货(1：是；0：否)*/
    private Integer printedPeihuo;

	/*配货打印时间*/
    private Date printPeihuoTime;

	/*seller_flag*/
    private Integer sellerFlag;

	/*物流公司是否线下网点 0:菜鸟,1线下网点 默认是淘宝菜鸟0*/
    private Integer wuliuOf;

	/*take_apart*/
    private Integer takeApart;

	/*part*/
    private Integer part;

	/*part_tids*/
    private String partTids;

	/*main_tid*/
    private Long mainTid;

	/*part_type*/
    private Integer partType;

	/*order_code*/
    private String orderCode;

	/*elec_type*/
    private String elecType;

	/*rds_modified*/
    private Date rdsModified;

	/*pbly*/
    private Integer pbly;



    public Long getTid() {
       return tid;
    }

    public void setTid(Long tid) {
       this.tid = tid;
    }

    public String getTitle() {
       return title;
    }

    public void setTitle(String title) {
       this.title = title;
    }

    public Float getPrice() {
       return price;
    }

    public void setPrice(Float price) {
       this.price = price;
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

    public Date getModified() {
       return modified;
    }

    public void setModified(Date modified) {
       this.modified = modified;
    }

    public Date getCreated() {
       return created;
    }

    public void setCreated(Date created) {
       this.created = created;
    }

    public String getStatus() {
       return status;
    }

    public void setStatus(String status) {
       this.status = status;
    }

    public String getType() {
       return type;
    }

    public void setType(String type) {
       this.type = type;
    }

    public String getShippingType() {
       return shippingType;
    }

    public void setShippingType(String shippingType) {
       this.shippingType = shippingType;
    }

    public Long getNum() {
       return num;
    }

    public void setNum(Long num) {
       this.num = num;
    }

    public String getPayment() {
       return payment;
    }

    public void setPayment(String payment) {
       this.payment = payment;
    }

    public String getDiscountFee() {
       return discountFee;
    }

    public void setDiscountFee(String discountFee) {
       this.discountFee = discountFee;
    }

    public String getTradeMemo() {
       return tradeMemo;
    }

    public void setTradeMemo(String tradeMemo) {
       this.tradeMemo = tradeMemo;
    }

    public String getSellerMemo() {
       return sellerMemo;
    }

    public void setSellerMemo(String sellerMemo) {
       this.sellerMemo = sellerMemo;
    }

    public String getBuyerMessage() {
       return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
       this.buyerMessage = buyerMessage;
    }

    public String getBuyerEmail() {
       return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
       this.buyerEmail = buyerEmail;
    }

    public Float getTotalFee() {
       return totalFee;
    }

    public void setTotalFee(Float totalFee) {
       this.totalFee = totalFee;
    }

    public Float getPostFee() {
       return postFee;
    }

    public void setPostFee(Float postFee) {
       this.postFee = postFee;
    }

    public String getReceiverName() {
       return receiverName;
    }

    public void setReceiverName(String receiverName) {
       this.receiverName = receiverName;
    }

    public String getReceiverState() {
       return receiverState;
    }

    public void setReceiverState(String receiverState) {
       this.receiverState = receiverState;
    }

    public String getReceiverCity() {
       return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
       this.receiverCity = receiverCity;
    }

    public String getReceiverDistrict() {
       return receiverDistrict;
    }

    public void setReceiverDistrict(String receiverDistrict) {
       this.receiverDistrict = receiverDistrict;
    }

    public String getReceiverAddress() {
       return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
       this.receiverAddress = receiverAddress;
    }

    public String getReceiverZip() {
       return receiverZip;
    }

    public void setReceiverZip(String receiverZip) {
       this.receiverZip = receiverZip;
    }

    public String getReceiverMobile() {
       return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
       this.receiverMobile = receiverMobile;
    }

    public String getReceiverPhone() {
       return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
       this.receiverPhone = receiverPhone;
    }

    public Integer getPrintedKuaidi() {
       return printedKuaidi;
    }

    public void setPrintedKuaidi(Integer printedKuaidi) {
       this.printedKuaidi = printedKuaidi;
    }

    public Integer getPrintedFahuo() {
       return printedFahuo;
    }

    public void setPrintedFahuo(Integer printedFahuo) {
       this.printedFahuo = printedFahuo;
    }

    public Long getMergeTid() {
       return mergeTid;
    }

    public void setMergeTid(Long mergeTid) {
       this.mergeTid = mergeTid;
    }

    public String getYdId() {
       return ydId;
    }

    public void setYdId(String ydId) {
       this.ydId = ydId;
    }

    public String getWuliu() {
       return wuliu;
    }

    public void setWuliu(String wuliu) {
       this.wuliu = wuliu;
    }

    public String getRemark() {
       return remark;
    }

    public void setRemark(String remark) {
       this.remark = remark;
    }

    public Date getPayTime() {
       return payTime;
    }

    public void setPayTime(Date payTime) {
       this.payTime = payTime;
    }

    public Date getPrintFahuoTime() {
       return printFahuoTime;
    }

    public void setPrintFahuoTime(Date printFahuoTime) {
       this.printFahuoTime = printFahuoTime;
    }

    public Date getPrintKuaidiTime() {
       return printKuaidiTime;
    }

    public void setPrintKuaidiTime(Date printKuaidiTime) {
       this.printKuaidiTime = printKuaidiTime;
    }

    public Date getFahuoTime() {
       return fahuoTime;
    }

    public void setFahuoTime(Date fahuoTime) {
       this.fahuoTime = fahuoTime;
    }

    public String getTradeGift() {
       return tradeGift;
    }

    public void setTradeGift(String tradeGift) {
       this.tradeGift = tradeGift;
    }

    public String getInvoiceName() {
       return invoiceName;
    }

    public void setInvoiceName(String invoiceName) {
       this.invoiceName = invoiceName;
    }

    public Integer getIsElec() {
       return isElec;
    }

    public void setIsElec(Integer isElec) {
       this.isElec = isElec;
    }

    public String getServiceTag() {
       return serviceTag;
    }

    public void setServiceTag(String serviceTag) {
       this.serviceTag = serviceTag;
    }

    public Integer getPrintedPeihuo() {
       return printedPeihuo;
    }

    public void setPrintedPeihuo(Integer printedPeihuo) {
       this.printedPeihuo = printedPeihuo;
    }

    public Date getPrintPeihuoTime() {
       return printPeihuoTime;
    }

    public void setPrintPeihuoTime(Date printPeihuoTime) {
       this.printPeihuoTime = printPeihuoTime;
    }

    public Integer getSellerFlag() {
       return sellerFlag;
    }

    public void setSellerFlag(Integer sellerFlag) {
       this.sellerFlag = sellerFlag;
    }

    public Integer getWuliuOf() {
       return wuliuOf;
    }

    public void setWuliuOf(Integer wuliuOf) {
       this.wuliuOf = wuliuOf;
    }

    public Integer getTakeApart() {
       return takeApart;
    }

    public void setTakeApart(Integer takeApart) {
       this.takeApart = takeApart;
    }

    public Integer getPart() {
       return part;
    }

    public void setPart(Integer part) {
       this.part = part;
    }

    public String getPartTids() {
       return partTids;
    }

    public void setPartTids(String partTids) {
       this.partTids = partTids;
    }

    public Long getMainTid() {
       return mainTid;
    }

    public void setMainTid(Long mainTid) {
       this.mainTid = mainTid;
    }

    public Integer getPartType() {
       return partType;
    }

    public void setPartType(Integer partType) {
       this.partType = partType;
    }

    public String getOrderCode() {
       return orderCode;
    }

    public void setOrderCode(String orderCode) {
       this.orderCode = orderCode;
    }

    public String getElecType() {
       return elecType;
    }

    public void setElecType(String elecType) {
       this.elecType = elecType;
    }

    public Date getRdsModified() {
       return rdsModified;
    }

    public void setRdsModified(Date rdsModified) {
       this.rdsModified = rdsModified;
    }

    public Integer getPbly() {
       return pbly;
    }

    public void setPbly(Integer pbly) {
       this.pbly = pbly;
    }

}