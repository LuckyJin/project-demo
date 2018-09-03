/*
package com.raycloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.raycloud.autocomment.domain.UserDomain;
import com.raycloud.order.common.util.TaobaoAPI2Util;
import com.raycloud.utils.date.DateUtil;
import com.raycloud.utils.exception.InvalidSessionException;
import com.taobao.api.domain.Trade;
import com.taobao.api.request.TradesSoldGetRequest;
import com.taobao.api.response.TradesSoldGetResponse;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/getData")
public class GetDataController {

    private static final String fileds = "buyer_nick,buyer_rate,seller_rate,num_iid,tid,orders.title,modified,end_time,orders.oid,orders.num_iid,orders.buyer_rate,orders.seller_rate,orders.status,orders.end_time,orders.pic_path,orders.num,orders.payment";

    private static final String status = "TRADE_FINISHED";

    public static final String TRADE_TYPE = "fixed,auction,step,guarantee_trade," +
            "independent_simple_trade,independent_shop_trade,auto_delivery," +
            "ec,cod,fenxiao,game_equipment,shopex_trade,netcn_trade,external_trade," +
            "instant_trade,b2c_cod,hotel_trade,super_market_trade," +
            "super_market_cod_trade,taohua,waimai,nopaid,eticket";

    @RequestMapping("/test")
    @ResponseBody
    public void test(HttpServletResponse response){
        Workbook wb =null;
        Sheet sheet = null;
        Row row = null;
        List<UserDomain> list = new ArrayList<UserDomain>();
        String cellData = null;
        String filePath = "E:\\test.xlsx";
        String columns[] = {"name","age","score"};
        wb = readExcel(filePath);
        if(wb != null){
            //获取第一个sheet
            sheet = wb.getSheetAt(0);
            //获取最大行数
            int rownum = sheet.getPhysicalNumberOfRows();
            //获取第一行
            row = sheet.getRow(0);
            //获取最大列数
            int colnum = row.getPhysicalNumberOfCells();
            for (int i = 1; i<rownum; i++) {
                row = sheet.getRow(i);
                if(row !=null){
                    UserDomain userDomain = new UserDomain();
                    for (int j=0;j<colnum;j++){
                        cellData = row.getCell(j).getStringCellValue();
                        if(j == 0){
                            userDomain.setTaobaoNick(cellData);
                        } else if(j == 1){
                           userDomain.setTopSession(cellData);
                        }
                    }
                    list.add(userDomain);
                }else{
                    break;
                }
            }
        }
        Date start = null;
        Date end = null;
        try {
            start = DateUtil.parseDateTime("2018-04-07 00:00:00");
            end = DateUtil.parseDateTime("2018-05-07 23:59:59");
        } catch (Exception e) {
            System.out.println("时间转换错误");
        }
        Date date = null;
        List<List<String>> results = new ArrayList<List<String>>();
        for(UserDomain userDomain: list){
            int count = 0;
            List<Trade> trades = null;
            List<String> tt = new ArrayList<String>();
            try {
                trades = queryWaitRateTradeList(userDomain, null,null);
            } catch (Exception e) {
                continue;
            }
            if(CollectionUtils.isNotEmpty(trades)){
                for(Trade trade: trades){
                    count = 0;
                    if(CollectionUtils.isNotEmpty(trade.getOrders())){
                        for(com.taobao.api.domain.Order order: trade.getOrders()){
                            date = order.getEndTime();
                            if(start.before(date) && end.after(date)){
                               count++;
                            }
                        }
                    }else{
                        date = trade.getEndTime();
                        if(start.before(date) && end.after(date)){
                            count++;
                        }
                    }
                }
                System.out.println(userDomain.getTaobaoNick() + "," + count);
            }
            tt.add(userDomain.getTaobaoNick());
            tt.add(String.valueOf(count));
            results.add(tt);
        }
        List<String> title = new ArrayList<String>();
        title.add("用户昵称");
        title.add("漏评订单数");
        try {
            DownloadUtil.downExcel(response,"data.xlsx", title, convertData(results));
        } catch (Exception e) {
            e.printStackTrace();
        }
       */
/* return results;*//*

    }

    public static Workbook readExcel(String filePath){
        Workbook wb = null;
        if(filePath==null){
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if(".xls".equals(extString)){
                return wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(extString)){
                return wb = new XSSFWorkbook(is);
            }else{
                return wb = null;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }

    @SuppressWarnings("Duplicates")
    public static List<Trade> queryWaitRateTradeList(UserDomain userDomain,
                                                     Date startDate, Date endDate)
            throws Exception {
        if (StringUtils.isBlank(userDomain.getTopSession())) {
            return Collections.emptyList();
        }
        long pageNo = 1L;
        long pageSize = 100L;
        TradesSoldGetRequest request = new TradesSoldGetRequest();
        request.setPageSize(pageSize);
        request.setPageNo(pageNo);
        //设置type
        request.setType(TRADE_TYPE);
        if (startDate != null) {
            request.setStartCreated(startDate);
        }
        if (endDate != null) {
            request.setEndCreated(endDate);
        }

        request.setStatus(status);

        request.setFields(fileds);
        request.setRateStatus("RATE_UNSELLER");
        request.setUseHasNext(Boolean.TRUE);
        TradesSoldGetResponse rsp = null;
        List<Trade> allTradeList = new ArrayList<Trade>();
        List<Trade> subTradeList = new ArrayList<Trade>(100);
        long exeNum = 0L;
        try {
            while (true) {
                request.setPageNo(pageNo++);
                rsp = (TradesSoldGetResponse) TaobaoAPI2Util.getTaobaoResponse(request, userDomain.getTopSession());
                exeNum++;
                if (rsp != null && rsp.isSuccess()) {
                    subTradeList = rsp.getTrades();
                    if (CollectionUtils.isNotEmpty(subTradeList)) {
                        for (Trade trade : subTradeList) {
                            allTradeList.add(trade);
                        }
                        subTradeList.clear();

                    }
                    if (BooleanUtils.isNotTrue(rsp.getHasNext())) {
                        break;
                    }
                } else {

                    throw new Exception("拉取用户待评价订单失败_" + JSONObject.toJSONString(rsp));
                }

            }
        } catch (InvalidSessionException e) {

            return Collections.emptyList();

        }

        return allTradeList;
    }

    public static List<RowModel> convertData(List<List<String>> results) {
        List<RowModel> dataLists = Lists.newArrayList();
        for (List<String> vo : results) {
            RowModel rowModel = new RowModel();
            List<String> cellList = Lists.newArrayList();
            cellList.add(vo.get(0));
            cellList.add(vo.get(1));
            rowModel.setCellList(cellList);
            dataLists.add(rowModel);
        }
        return dataLists;
    }
}
*/
