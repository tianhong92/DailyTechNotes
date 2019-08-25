package com.tianhong.demo.thread.MultiThread.sync;

import com.tianhong.demo.thread.MultiThread.CustomMultiThreadingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MultiThreadProcessService {

    private Logger logger = LoggerFactory.getLogger(MultiThreadProcessService.class);
    /**
     * 默认处理流程耗时1000ms
     */
    public void processSomething() {
        System.out.println("???????????");
        logger.debug("MultiThreadProcessService-processSomething" + Thread.currentThread() + "......start");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.debug("MultiThreadProcessService-processSomething" + Thread.currentThread() + "......end");
    }
}