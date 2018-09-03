package com.cn.service;

import com.cn.dao.TestDao;
import com.raycloud.dubbo.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService implements DemoService {

    @Autowired(required = false)
    private TestDao testDao;

    @Override
    public String testDemo(){

        return testDao.testDao();
    }

}
