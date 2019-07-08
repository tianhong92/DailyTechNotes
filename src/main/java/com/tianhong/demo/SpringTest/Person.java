package com.tianhong.demo.SpringTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component("person")
public class Person {
    @Value("Haha")
    private String name;

    @Autowired
    @Qualifier("doggy")
    private Pet pet;

    public Person(String name) {
        this.name = name;
    }

    public Pet getPet() {
        return pet;
    }

    public Person() {

    }

    public String getName() {
        return this.name;
    }

    public void setName() {
        this.name = name;
    }
}
