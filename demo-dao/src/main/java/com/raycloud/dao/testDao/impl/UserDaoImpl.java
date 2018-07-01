package com.raycloud.dao.testDao.impl;

import com.raycloud.dao.bean.User;
import com.raycloud.dao.testDao.UserDao;
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
