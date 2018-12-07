package com.cn.service.common.util;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeoutException;

@Component("memcachedUtil")
public class MemcachedUtil {

    private final Logger LOGGER = Logger.getLogger(MemcachedUtil.class);

    private final int DEFAULT_KEEP_TIME = 3600;

    @Resource
    private MemcachedClient memcachedClient;

    public void set(String key, Object value) {
        try {
            memcachedClient.set(key, DEFAULT_KEEP_TIME, value);
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            LOGGER.error("memcached set 异常:" + e.getMessage());
        }
    }

    public Object get(String key){
        try {
            return memcachedClient.get(key);
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            LOGGER.error("memcached get 异常:" + e.getMessage());
        }

        return null;
    }
}
