package com.example.wuyou.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CollectTypeEnum {
    SCGW("收藏职位", 0),
    SCJL("收藏简历", 1);

    @EnumValue
    private final int value;
    @JsonValue
    private final String text;


    CollectTypeEnum(String text, int value) {
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
