package com.tianhong.demo.IOCDemo.BeanInit;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by TianhongWang on 2019/8/8
 */

@RestController
public class TestController {

    @Scope(WebApplicationContext.SCOPE_SESSION)
    @RequestMapping("test")
    @ResponseBody
    public String test() {
        return this.toString();
    }

    @RequestMapping("test2")
    @ResponseBody
    public String test2() {
        return this.toString();
    }
}
