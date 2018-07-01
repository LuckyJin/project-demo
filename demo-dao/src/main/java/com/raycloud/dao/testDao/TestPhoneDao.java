package com.raycloud.dao.testDao;

import com.raycloud.dao.bean.TestPhone;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("testPhoneDao")
public interface TestPhoneDao {

    public TestPhone getPhoneById(int id);
}
