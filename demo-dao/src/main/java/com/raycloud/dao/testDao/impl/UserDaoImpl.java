package com.cn.dao.testDao.impl;

import com.cn.dao.bean.User;
import com.cn.dao.testDao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public User querySessionUser(String nick) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public int updateSessionUser(User user) {
        return 0;
    }
}
