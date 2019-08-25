package com.tianhong.demo.EnumTest;

public enum FirmConfig {
    CLOUD(1, "云存"), FACE(2, "人脸"), TRAFFIC(3, "流量");
    private final int value;
    private final String lable;

    FirmConfig(int value, String lable) {
        this.value = value;
        this.lable = lable;
    }

    public int getValue() {
        return value;
    }
    public String getLable() {
        return lable;
    }
}
