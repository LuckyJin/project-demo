package com.cn.controller;


import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {

    protected  HttpServletRequest request(){
        RequestAttributes requestAttribute = RequestContextHolder.getRequestAttributes();
        if(requestAttribute instanceof ServletRequestAttributes){
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)requestAttribute;
            return servletRequestAttributes.getRequest();
        }
        throw new UnsupportedOperationException();
    }

    protected HttpServletResponse response(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
            return servletRequestAttributes.getResponse();
        }
        throw new UnsupportedOperationException();
    }

}
