package com.cn.dao.testDao;

import com.cn.dao.bean.UserInfo;

import java.util.List;

public interface UserInfoDao {

    public int insertUserInfo(UserInfo userInfo);

    public int delete(UserInfo userInfo);

    public int updateUserInfo(UserInfo urInfo);

    public List<UserInfo> selectByUserId(String userId);

    public UserInfo selectUserInfo(long taobaoId);
}