/*
package com.raycloud.controller;

import com.google.common.collect.Lists;
import com.raycloud.admin.client.api.UserDubboService;
import com.raycloud.admin.client.domain.SuperUser;
import com.raycloud.admin.client.request.GetUserInfoRequest;
import com.raycloud.admin.client.response.GetUserInfoResponse;
import com.raycloud.customer.background.client.api.RefundOrderService;
import com.raycloud.dao.bean.ApiMessage;
import com.raycloud.dao.superdelivery2.ApiMessageDao;
import com.raycloud.service.TestService;
import com.raycloud.wjc.api.PreScanService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//@RestController
//@RequestMapping("/test")
public class OtherController extends BaseController {

    @Resource
    private TestService testService;

    @Resource
    private HttpServletRequest request;

    @Resource
    private ApiMessageDao apiMessageDao;

    @Resource
    private PreScanService preScanService;

    @Resource
    private RefundOrderService refundOrderService;

    @Resource
    private UserDubboService userDubboService;

    //@RequestMapping("/testDemo")
    public String testDemo() {


        //System.out.println( testService.testDemo());
       */
/* try {
            SessionUser sessionUser = getSessionUser();
            System.out.println(sessionUser.getTaobaoNick());
        } catch (Exception e) {
            e.printStackTrace();
        }*//*

        try {
            String ip = request.getHeader("X-real-ip");
            String addr = request.getRemoteAddr();

            return "Hello from " + ip + "  " + addr + "  " + InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

   // @RequestMapping("testDataSource")
    public void testDataSource() {
        List<ApiMessage> list = apiMessageDao.selectApiMessage();
        System.out.println(list == null);
    }


    */
/*@RequestMapping("/uploadPic")
    public void uploadPic(MultipartFile file, HttpServletRequest request) {
        String originalFileName = file.getOriginalFilename();
        String type = originalFileName.indexOf(".") != -1 ? originalFileName.substring(originalFileName.lastIndexOf(".") + 1, originalFileName.length()) : null;

        boolean checkType = type != null && ("PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase()));
        Preconditions.checkArgument(checkType, "错误的文件类型");

        String trueFileName = String.valueOf(System.currentTimeMillis()) + originalFileName;

        String path = request.getSession().getServletContext().getRealPath("temp/");

        String realPath = path + "/" + trueFileName;

        File targetDir = new File(path);
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }
        try {
            file.transferTo(new File(realPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = "temp/" + trueFileName;
    }*//*


   // @RequestMapping("test")
    public GetUserInfoResponse test(Long taobaoId, String taobaoNick) {
        */
/*InsertRefundOrderRequest refundOrderRequest = new InsertRefundOrderRequest();
        refundOrderRequest.setAlipayId("123");
        refundOrderRequest.setChargeItem("test");
        refundOrderRequest.setContactCustomerServicer("test");
        refundOrderRequest.setHasBadReview(1);
        refundOrderRequest.setHasComplaints(1);
        refundOrderRequest.setOrderDuration("1");
        refundOrderRequest.setOrderVersion("高级版");
        refundOrderRequest.setPicUrl("temp/1519439817204test.jpg");
        refundOrderRequest.setReason("test");
        refundOrderRequest.setRefundFee("1");
        refundOrderRequest.setRequestDate(new Date());
        refundOrderRequest.setRemainedTime(150);
        refundOrderRequest.setTaobaoNick("test");

        BaseResponse baseResponse = refundOrderService.insertRefundOrder(refundOrderRequest);
        baseResponse.isSuccess();

        QueryRefundRecordRequest request = new QueryRefundRecordRequest();
        request.setTaobaoNick("test");
        QueryRefundRecordResponse response = refundOrderService.queryRefundRecord(request);
        response.getList();*//*


        */
/*GetPreScanActionRequest request = new GetPreScanActionRequest();
        request.setTaobaoId(taobaoId);
        request.setTaobaoNick(taobaoNick);
        GetPreScanActionResponse response = preScanService.getPreScanAction(request);*//*


        GetUserInfoRequest getUserInfoRequest = new GetUserInfoRequest();
        getUserInfoRequest.setTaobaoId(653096500L);
        GetUserInfoResponse getUserInfoResponse = userDubboService.getUserInfo(getUserInfoRequest);
        SuperUser user = getUserInfoResponse.getUser();

        System.out.println(user.getTopSession());
        Set<String> set = new HashSet<>();

        return getUserInfoResponse;
    }


    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Iterator<String> re = list.iterator();
        try {
            while (re.hasNext()){
                String tt = re.next();
                Thread.sleep(3000);
                System.out.println(tt);
                if(tt.equals("b") || tt.equals("c")){
                    re.remove();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        */
/*for(String test: list){
            System.out.print(" " + test + " ");
        }*//*

    }

    public static void add(String[] data){

    }

   */
/* @RequestMapping("/test")
    @ResponseBody
    public void test(HttpServletResponse response){
        StringBuilder titleBuilder = new StringBuilder();
        titleBuilder.append("商品.xls");

        List<String> titles = Lists.newArrayList();
        titles.add("日期");
        titles.add("商品浏览量");
        titles.add("商品访客数");
        titles.add("有被访问的商品数");
        titles.add("下单商品数");
        titles.add("有下单商品数");
        titles.add("付款商品数");
        titles.add("有付款商品数");

        DownloadUtil.downExcel(response, titleBuilder.toString(), titles, Lists.newArrayList());
    }*//*




}
*/
