package com.tianhong.demo.SpringTest;

import org.springframework.stereotype.Component;

@Component(value = "doggy")
public class Dog implements Pet{
    public void move() {
        System.out.println("Dog is running!");
    }
}
