package com.loskatt.appoint.common;

public enum Gender {
    UNKNOW(2, "未知"),
    MAN(1, "先生"),
    WOMAN(0, "女士");

    private Byte value;
    private String name;

    Gender(int value, String name) {
        this.value = (byte)value;
        this.name = name;
    }

    public Byte getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }
}
