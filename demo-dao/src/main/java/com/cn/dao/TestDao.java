package com.cn.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Repository
public class TestDao {

    public String testDao(){
        return "Hello";
    }

    public String getPhone(int id){
        return null;
    }
}
