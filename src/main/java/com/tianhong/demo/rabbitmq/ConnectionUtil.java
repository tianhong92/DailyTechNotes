package com.tianhong.demo.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;

public class ConnectionUtil {
    private static Connection existConnection = null;

    public static Connection getConnection(String vh) throws Exception {
        if (existConnection != null) {
            return existConnection;
        } else {
            //定义连接工厂
            ConnectionFactory factory = new ConnectionFactory();
            //设置服务地址
            factory.setHost("120.27.148.199");
            //端口
            factory.setPort(5672);
            //设置账号信息，用户名、密码、vhost(beijing_vh, india_vh, usa_vh)
            factory.setVirtualHost(vh);
            factory.setUsername("guest");
            factory.setPassword("manniu");
            // 通过工程获取连接
            Connection connection = factory.newConnection();
            existConnection = connection;
            return connection;
        }
    }

}
