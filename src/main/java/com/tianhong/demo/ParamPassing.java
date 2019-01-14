package com.tianhong.demo;

/**
 * @author TianhongWang
 * @since 2019/1/10
 */

public class ParamPassing {
    private static int intStatic = 222;
    private static String stringStatic = "old string";
    private static StringBuilder stringBuilderStatic = new StringBuilder("old stringBuilder");

    public static void main(String[] args) {
        //实参调用
        method(intStatic);
        method(stringStatic);
        method(stringBuilderStatic, stringBuilderStatic);

        // 输出依然是222（第一处）
        System.out.println(intStatic);
        method();

        // 无参方法调用之后， 反而修改为888（第二处）
        System.out.println(intStatic);
        // 输出依然是 old string
        System.out.println(stringStatic);
        // 输出结构参考下方分析
        System.out.println(stringBuilderStatic);
    }

    // A 方法
    public static void method(int initStatic){
        intStatic = 777;
    }

    // B 方法
    public static void method(){
        intStatic = 888;
    }

    // C 方法
    public static void method(String stringStatic){
        // String是immutable对象， String没有提供任何方法用于修改对象
        stringStatic = "new String";
    }

    // D 方法
    public static void method(StringBuilder stringBuilderStatic1, StringBuilder stringBuilderStatic2){
        // 直接调用参数引用修改对象（第三处）
        stringBuilderStatic1.append(".method.first-");
        stringBuilderStatic2.append("method.second-");

        // 引用重新赋值
        stringBuilderStatic1 = new StringBuilder("new stringBuilder");
        stringBuilderStatic1.append("new method's append");
    }
}
