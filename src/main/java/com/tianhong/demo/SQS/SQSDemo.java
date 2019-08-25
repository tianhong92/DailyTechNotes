package com.tianhong.demo.SQS;


import com.alibaba.fastjson.JSON;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.SendMessageRequest;

import java.util.List;


public class SQSDemo {
    public static void main(String[] args) {
        AmazonSQS sqs = AmazonSQSClient.builder()
                .withRegion(Regions.CN_NORTH_1)
                .withCredentials(new ClasspathPropertiesFileCredentialsProvider("/AwsCredentials.properties"))
                .build();

        String queueUrl = sqs.getQueueUrl("bj_sqs").getQueueUrl();

        ManniuMessage msg = new ManniuMessage("sms_config", "drop", "null");
        String text = JSON.toJSONString(msg);
        System.out.println(text);
        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(queueUrl)
                .withMessageBody(text);
        sqs.sendMessage(send_msg_request);

        // receive messages from the queue
        List<Message> messages = sqs.receiveMessage(queueUrl).getMessages();

        // delete messages from the queue
        for (Message m : messages) {
            sqs.deleteMessage(queueUrl, m.getReceiptHandle());
            System.out.println(m.getBody());
            ManniuMessage mm = JSON.parseObject(m.getBody(), ManniuMessage.class);
        }

    }
}
