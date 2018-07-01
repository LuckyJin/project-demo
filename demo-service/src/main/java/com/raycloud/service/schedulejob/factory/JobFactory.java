package com.raycloud.service.schedulejob.factory;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import javax.annotation.Resource;

public class JobFactory extends SpringBeanJobFactory {

    @Resource
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        //调用父类的方法
        Object jobInstance = super.createJobInstance(bundle);
        //进行注入
        autowireCapableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
