package com.tianhong.demo.EffectiveJava;


import java.util.HashSet;
import java.util.Set;

public class GenericTest {
    public static void main(String[] args) {
//        Box<String> name = new Box<String>("corn");
//        Box<Integer> age = new Box<Integer>(88);
//
//        System.out.println("name class: " + name.getClass());
//        System.out.println("age class: "+age.getClass());
//        System.out.println(name.getClass() == age.getClass());


        Box<Number> name1 = new Box<Number>(99);
        Box<Integer> age1 = new Box<Integer>(712);
        getData(name1);
        getData(age1);   // 1

        Set hah = new HashSet<>();
        genericMethod(hah, hah);


    }

    // extends通配符上限；
    // super 通配符下限；
    public static void getData(Box<? extends Number> data){
        System.out.println("data :" + data.getData());
    }

    public static int genericMethod(Set<Object> s1, Set<Object> s2){
        int result = 0;
        for(Object o1 : s1){
            if(s2.contains(01)){
                result++;
            }
        }
        return result;
    }
}
