package com.cn.dao.testDao;

import com.cn.dao.bean.TestPhone;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("testPhoneDao")
public interface TestPhoneDao {

    public TestPhone getPhoneById(int id);
}
