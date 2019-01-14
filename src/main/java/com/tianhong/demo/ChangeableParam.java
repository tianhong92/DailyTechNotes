package com.tianhong.demo;

/**
 * @author TianhongWang
 * @since 2019/1/14
 */
public class ChangeableParam {
    public static void main(String[] args) {
        userLength(1, 2, "4");
        userLength(new int[]{1, 2});
    }
    public static void userLength(Object... args){
        System.out.println(args.length);
    }
}
