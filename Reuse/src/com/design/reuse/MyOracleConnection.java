package com.design.reuse;

public class MyOracleConnection extends DBConnection{

    @Override
    public String getConnection() {
        return "获取Oracle数据库连接";
    }
}
