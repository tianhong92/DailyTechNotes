package com.tianhong.demo.EnumTest;

import java.util.Arrays;
import java.util.List;

public class enumTest {
    public static void main(String[] args) {
        List<FirmConfig> list = Arrays.asList(FirmConfig.values());
        System.out.println(list.get(0).getValue());
    }
}
