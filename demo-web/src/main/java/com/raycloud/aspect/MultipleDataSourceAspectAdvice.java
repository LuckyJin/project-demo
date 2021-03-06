package com.cn.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 多数据源，不同表用
/*@Component
@Aspect*/
public class MultipleDataSourceAspectAdvice {
    @Around("execution(* com.cn.dao.testDao.*.*(..))")
    public Object doAround1(ProceedingJoinPoint jp) throws Throwable {
        MultipleDataSource.setThreadLocalDatasource("dataSource1");
        return jp.proceed();
    }

    @Around("execution(* com.cn.dao.superdelivery2.*.*(..))")
    public Object doAround2(ProceedingJoinPoint jp) throws Throwable {
        MultipleDataSource.setThreadLocalDatasource("dataSource2");
        return jp.proceed();
    }
}
