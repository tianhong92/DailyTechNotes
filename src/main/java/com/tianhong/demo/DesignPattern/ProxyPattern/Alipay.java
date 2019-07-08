package com.tianhong.demo.DesignPattern.ProxyPattern;

public class Alipay implements Payment {
    private Payment payment;

    public Alipay(Payment payment) {
        this.payment = payment;
    }

    public void beforePay() {
        System.out.println("支付前。。。");
    }

    public void afterPay() {
        System.out.println("支付后。。。");
    }

    @Override
    public void pay() {
        beforePay();
        payment.pay();
        afterPay();
    }
}
