package com.tianhong.demo.IOCDemo;

public abstract class HumanWithCar implements Human {

    protected Car car;

    public HumanWithCar(Car car) {
        this.car = car;
    }

    @Override
    public abstract void goHome();
}
