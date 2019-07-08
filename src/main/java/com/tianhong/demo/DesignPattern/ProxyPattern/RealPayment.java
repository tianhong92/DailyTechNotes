package com.tianhong.demo.DesignPattern.ProxyPattern;

//真实类
public class RealPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("用户只关心支付功能， 不关心具体实现！");
    }
}
