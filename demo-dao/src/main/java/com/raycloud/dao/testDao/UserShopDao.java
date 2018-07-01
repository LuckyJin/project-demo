package com.raycloud.dao.testDao;

import com.raycloud.dao.bean.UserShop;

import java.util.List;

public interface UserShopDao {

    public int insert(UserShop userShop);

    public int delete(UserShop userShop);

    public int update(UserShop userShop);

    public List<UserShop> selectByUserId(int userId);
}
