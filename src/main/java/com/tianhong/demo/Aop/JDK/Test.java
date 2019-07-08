package com.tianhong.demo.Aop.JDK;

import java.lang.reflect.Proxy;

// 一种是基于JDK的动态代理

public class Test {
    public static void main(String[] args) {
        long start = System.nanoTime();
        CalcService target = new CalcServiceImpl();
        CalcHandler handler = new CalcHandler(target);
        CalcService calcProxy = (CalcService)Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler);
        System.out.println("创建时间：" + (System.nanoTime()-start));
        start = System.nanoTime();
        calcProxy.add(2, 3);
        System.out.println("执行时间：" + (System.nanoTime()-start));
    }
}
