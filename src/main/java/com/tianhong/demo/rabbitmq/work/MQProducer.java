package com.tianhong.demo.rabbitmq.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.tianhong.demo.rabbitmq.ConnectionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MQProducer {
    private static final Logger LOGGER = LogManager.getLogger(MQProducer.class);

    public static void produce(String vh, String queue, String message) {
        try {
            // 获取到连接以及mq通道
            Connection connection = ConnectionUtil.getConnection(vh);
            // 从连接中创建通道
            Channel channel = connection.createChannel();

            // 声明（创建）队列
            channel.queueDeclare(queue, true, false, false, null);

            // 消息内容
            channel.basicPublish("", "", null, message.getBytes());
            //关闭通道和连接
            channel.close();
            connection.close();
        } catch (Exception e) {
            LOGGER.error("Rabbit mq produce fail!!");
        }
    }

}
