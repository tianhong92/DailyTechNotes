package com.tianhong.demo.thread.MultiThread.sync;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by TianhongWang on 2019/8/25
 */

@RestController
public class MainController {

    @Autowired
    private MultiThreadTest multiThreadTest;

    @RequestMapping(path = "/user",method = RequestMethod.GET)
    public void testThread() {
        multiThreadTest.test();
    }
}
