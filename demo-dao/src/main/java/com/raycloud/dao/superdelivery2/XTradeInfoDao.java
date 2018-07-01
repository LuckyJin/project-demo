package com.raycloud.dao.superdelivery2;

import com.raycloud.dao.bean.XTradeInfo;

import java.util.List;
import java.util.Map;

public interface XTradeInfoDao {

    public long getCount();

    public List<XTradeInfo> getPageList(Map<String, Object> query);
}
