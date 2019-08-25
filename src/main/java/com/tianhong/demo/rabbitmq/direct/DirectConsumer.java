package com.tianhong.demo.rabbitmq.direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.tianhong.demo.rabbitmq.ConnectionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DirectConsumer {
    private static final Logger LOGGER = LogManager.getLogger(DirectConsumer.class);

    public static String consume(String vh,  String exchange, String queue, String key) {
        String ret = "";
        // 获取到连接以及mq通道
        try {
            Connection connection = ConnectionUtil.getConnection(vh);
            // 从连接中创建通道
            Channel channel = connection.createChannel();
            // 声明队列
            channel.queueDeclare(queue, true, false, false, null);
            channel.queueBind(queue, exchange, key);
            // 定义队列的消费者
            QueueingConsumer consumer = new QueueingConsumer(channel);
            // 监听队列,手动返回完成状态
            channel.basicConsume(queue, false, consumer);
            channel.basicQos(1);


            // 获取消息
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            ret = new String(delivery.getBody());
            Thread.sleep(10);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            channel.close();
            connection.close();
        } catch (Exception e) {
            LOGGER.error("Rabbit mq direct consume fail!");
        }
        return ret;
    }
}
