package com.cn.dao.testDao;

import com.cn.dao.bean.UserOrder;

import java.util.List;

public  interface UserOrdererDao {

    public int insert(UserOrder userOrder);

    public int delete(UserOrder userOrder);

    public int update(UserOrder userOrder);

    public List<UserOrder> selectByUserId(int userId);
}
