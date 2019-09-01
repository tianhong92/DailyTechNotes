package com.tianhong.demo.JavaBasic;

/**
 * Created by TianhongWang on 2019/9/1
 */
public class SubClass extends SuperClass {
    int a = 2;
    public void printA() {
        System.out.println("Sub print a = "+a);
    }

    public static void main(String[] args) {
        //子类转父类
        SuperClass sup = new SubClass();;
        System.out.println(sup.getClass());
        System.out.println(sup.a);
        sup.printA();

        //父类转子类
//        SubClass sub = (SubClass) new SuperClass();
//        sub.printA();

        SubClass sub1 = new SubClass();
        SuperClass sup1 = sub1;
        SubClass sub2 = (SubClass) sup1;
        sub2.printA();
    }
}
