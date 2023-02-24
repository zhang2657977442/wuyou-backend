package com.example.wuyou.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AuthStatusEnum {
    WRZ("未认证", 0),
    DDRZ("等待认证", 1),
    RZSB("认证失败", 2),
    RZTG("认证通过", 3);
    @EnumValue
    private final int value;
    @JsonValue
    private final String text;


    AuthStatusEnum(String text, int value) {
        this.text = text;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }


}
