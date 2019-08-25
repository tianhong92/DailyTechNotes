package com.tianhong.demo.rabbitmq.direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.tianhong.demo.rabbitmq.ConnectionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DirectProducer {
    private static final Logger LOGGER = LogManager.getLogger(DirectProducer.class);

    public static void produce(String vh, String exchange, String key, String message)  {
        try {
            // 获取到连接以及mq通道vh
            Connection connection = ConnectionUtil.getConnection(vh);
            // 从连接中创建通道
            Channel channel = connection.createChannel();

            // 声明（创建）队列
            channel.exchangeDeclare(exchange, "direct", true);

            // 消息内容

            channel.basicPublish(exchange, key, null, message.getBytes());
            //关闭通道和连接
            channel.close();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}
