package com.tianhong.demo.Aop.JDK;

public class CalcServiceImpl implements  CalcService {

    @Override
    public void add(int x, int y) {
        System.out.println("结果为" + (x + y));
    }
}
