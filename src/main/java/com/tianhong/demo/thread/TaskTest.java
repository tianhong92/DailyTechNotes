package com.tianhong.demo.thread;

import com.tianhong.demo.rabbitmq.direct.DirectProducer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:/app.properties")
public class TaskTest {


    @Scheduled(cron = "${cron.every}")
    public void simpleTask() throws Exception {
//        System.out.println("Get method simple task");
//        DirectProducer.produce("dev_vh", "direct_exchange", "pushappconfig", "dfa");
//        System.out.println("Finish method simple task");
    }

}
