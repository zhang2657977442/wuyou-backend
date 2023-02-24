package com.example.wuyou.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserStatusEnum {
    ZC("正常", 0),
    JY("禁用", 1),
    SHZ("审核中", 2),
    SHJJ("审核拒绝", 3);
    @EnumValue
    private final int value;
    @JsonValue
    private final String text;


    UserStatusEnum(String text, int value) {
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
