package com.cn.service.schedulejob;

import com.cn.service.common.util.MemcachedUtil;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;

@DisallowConcurrentExecution //不允许并发执行，如果任务执行时间超过任务执行间隔，则等待当前执行完成再重新执行，否则会开启新的线程执行
public class ScheduledJob extends QuartzJobBean {

    @Resource  //spring + quartz 注入方式不一致
    private MemcachedUtil memcachedUtil;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        memcachedUtil.set("TEST", "test");

        System.out.println("ScheduledJob is working");

        System.out.println(memcachedUtil.get("TEST"));

    }
}
