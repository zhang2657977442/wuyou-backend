package com.example.wuyou.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ApplyTypeEnum {
    TDJL("投递简历", 0),
    MSYQ("面试邀请", 1);

    @EnumValue
    private final int value;
    @JsonValue
    private final String text;


    ApplyTypeEnum(String text, int value) {
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
