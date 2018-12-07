package com.cn.controller;

import com.cn.service.mq.producer.ActiveMqProducer;

public class MqTestController {

    public static void main(String[] args){
        ActiveMqProducer producer = new ActiveMqProducer();
        producer.init();


    }
}
