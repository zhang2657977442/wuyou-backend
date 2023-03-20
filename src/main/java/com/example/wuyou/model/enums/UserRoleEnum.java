package com.example.wuyou.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserRoleEnum {
    DEFAULT("求职者", 0),
    BOSS("招聘者", 1),
    ADMIN("管理员", 2);


    @EnumValue
    private final int value;
    @JsonValue
    private final String text;


    UserRoleEnum(String text, int value) {
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
