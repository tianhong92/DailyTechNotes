package com.tianhong.demo.IOCDemo;

public class ZhangSan extends HumanWithCar {

    public ZhangSan(Car car) {
        super(car);
    }

    @Override
    public void goHome() {
        car.start();
        car.turnLeft();
        car.turnRight();
        car.stop();
    }
}
