package com.raycloud.service;

import com.raycloud.dao.TestDao;
import com.raycloud.dubbo.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestService implements DemoService {

    @Autowired(required = false)
    private TestDao testDao;

    @Override
    public String testDemo(){

        return testDao.testDao();
    }

}
