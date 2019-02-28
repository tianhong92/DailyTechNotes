package com.tianhong.demo.EffectiveJava;

import java.util.ArrayList;
import java.util.List;

public class TestGenericity {
    public static void main(String[] args) {
        List list  = new ArrayList();
        list.add("test one");
        list.add("test two");

        list.add(123);
        for(int i = 0; i < list.size(); i++){
            // 出现java.lang.ClassCastException
            String item = (String)list.get(i);
            System.out.println("item: "+item);
        }

        // 采用泛型
        List<String> list2 = new ArrayList<>();
        //编译不过
        //list2.add(23);

    }
}
