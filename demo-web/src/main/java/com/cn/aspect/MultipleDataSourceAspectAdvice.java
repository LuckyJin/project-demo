package com.cn.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

// 多数据源，不同表用
/*@Component
@Aspect*/
public class MultipleDataSourceAspectAdvice {
    @Around("execution(* com.raycloud.dao.testDao.*.*(..))")
    public Object doAround1(ProceedingJoinPoint jp) throws Throwable {
        MultipleDataSource.setThreadLocalDatasource("dataSource1");
        return jp.proceed();
    }

    @Around("execution(* com.raycloud.dao.superdelivery2.*.*(..))")
    public Object doAround2(ProceedingJoinPoint jp) throws Throwable {
        MultipleDataSource.setThreadLocalDatasource("dataSource2");
        return jp.proceed();
    }
}
