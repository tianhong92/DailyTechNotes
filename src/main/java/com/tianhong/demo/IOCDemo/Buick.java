package com.tianhong.demo.IOCDemo;

public class Buick implements Car {

    @Override
    public void start() {
        System.out.println("Buick.start");
    }

    @Override
    public void stop() {
        System.out.println("Buick.stop");
    }

    @Override
    public void turnLeft() {
        System.out.println("Buick.turnLeft");
    }

    @Override
    public void turnRight() {
        System.out.println("Buick.turnRight");
    }
}
