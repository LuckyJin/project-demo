package com.cn.controller;

import com.cn.service.StaticFactory;
import com.cn.service.StaticFactoryHandler;
import com.cn.service.common.enums.StaticFactoryType;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("staticFactory")
public class StaticFactoryController extends BaseController {

    private static final Logger logger = Logger.getLogger(StaticFactoryController.class);

    @RequestMapping("test")
    public void testStaticFactory(){
        StaticFactoryHandler handler = StaticFactory.getHandler(StaticFactoryType.A);
        handler.handle();
        logger.info("测试测试测试测试来一发吧");
    }

    public static void main(String[] args){

        HashMap<String,String> hashMap = new HashMap<>(5);
        System.out.println(hashMap.size());

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();

    }
}
