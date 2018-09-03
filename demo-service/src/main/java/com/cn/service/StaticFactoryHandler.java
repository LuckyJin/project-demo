package com.cn.service;

import com.cn.service.common.enums.StaticFactoryType;

public interface StaticFactoryHandler {

    StaticFactoryType getHandlerName();

    void handle();

}
