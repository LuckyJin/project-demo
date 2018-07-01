package com.raycloud.service;

import com.google.common.collect.Maps;
import com.raycloud.service.common.enums.StaticFactoryType;

import java.util.Map;

public class StaticFactory {

    private static Map<StaticFactoryType, StaticFactoryHandler> handlers = Maps.newHashMap();

    public static StaticFactoryHandler getHandler(StaticFactoryType goal){
        return handlers.get(goal);
    }

    public static void setHandler(StaticFactoryHandler handler){
        handlers.put(handler.getHandlerName(), handler);
    }

}
