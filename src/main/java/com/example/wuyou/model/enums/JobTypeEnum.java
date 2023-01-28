package com.example.wuyou.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum JobTypeEnum {
    FULL("全职", 0),
    PART("兼职", 1);

    @EnumValue
    private final int value;
    @JsonValue
    private final String text;


    JobTypeEnum(String text, int value) {
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
