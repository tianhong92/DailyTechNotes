package com.tianhong.demo.DesignPattern.ProxyPattern;

public class test {
    public static void main(String[] args) {
        Alipay proxy = new Alipay(new RealPayment());
        proxy.pay();
    }
}
