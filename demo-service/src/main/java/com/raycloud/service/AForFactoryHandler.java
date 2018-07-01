package com.raycloud.service;

import com.raycloud.service.common.enums.StaticFactoryType;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AForFactoryHandler implements StaticFactoryHandler{

    @Override
    public StaticFactoryType getHandlerName() {
        return StaticFactoryType.A;
    }

    @Override
    public void handle() {
        System.out.println("Here is A Handler!");
    }

    @PostConstruct
    public void registerHandler(){
        StaticFactory.setHandler(this);
    }
}
