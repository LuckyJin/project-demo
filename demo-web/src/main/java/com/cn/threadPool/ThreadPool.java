package com.cn.threadPool;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ThreadPool implements InitializingBean {

    private ExecutorService startPool = Executors.newFixedThreadPool(5);

    @Override
    public void afterPropertiesSet() throws Exception {
        for(int i = 0 ; i < 5 ; i++){
            TestThread temp = new TestThread(i);
            startPool.execute(temp);
        }
    }

    private class TestThread implements Runnable{

        private int i;

        public TestThread(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println("这是第" + i + "个测试线程");
        }
    }
}
