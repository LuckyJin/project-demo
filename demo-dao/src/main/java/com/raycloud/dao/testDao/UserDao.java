package com.cn.dao.testDao;

import com.cn.dao.bean.User;

public interface UserDao {
    User querySessionUser(String nick);

    void save(User user);

    int updateSessionUser(User user);
}
