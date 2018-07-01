package com.raycloud.dao.testDao;

import com.raycloud.dao.bean.User;

public interface UserDao {
    User querySessionUser(String nick);

    void save(User user);

    int updateSessionUser(User user);
}
