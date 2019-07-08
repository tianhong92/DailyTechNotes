package com.tianhong.demo.SpringTest;

import org.springframework.stereotype.Component;

@Component
public class Bird implements Pet {
    @Override
    public void move() {
        System.out.println("Bird is running!");
    }
}
