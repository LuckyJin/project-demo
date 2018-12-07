package com.cn.controller;

import com.cn.dao.bean.User;
import com.cn.dao.testDao.UserDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserDao userDao;

    @RequestMapping("save")
    @ResponseBody
    public User save(){
        User user = new User();
        user.setCreated(new Date());
        user.setModified(new Date());
        user.setPhone("12345678910");
        user.setUserId(1L);
        user.setUsername("xiaoming");
        user.setPwd("123");

        userDao.save(user);
        return user;
    }
}
