package com.raycloud.aspect;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class MultipleDataSource extends AbstractRoutingDataSource {

    private static ThreadLocal<String> threadLocalDatasource=new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return null;
        }
    };

    public static void setThreadLocalDatasource(String dsName){
        threadLocalDatasource.set(dsName);
    }


    @Override
    protected Object determineCurrentLookupKey() {
        return threadLocalDatasource.get();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
