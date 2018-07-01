package com.raycloud.service;

import com.raycloud.service.common.enums.StaticFactoryType;

public interface StaticFactoryHandler {

    StaticFactoryType getHandlerName();

    void handle();

}
