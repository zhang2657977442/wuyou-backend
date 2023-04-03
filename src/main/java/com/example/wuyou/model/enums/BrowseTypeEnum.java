package com.example.wuyou.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BrowseTypeEnum {
    LLGW("浏览公司", 0),
    LLJL("浏览简历", 1);

    @EnumValue
    private final int value;
    @JsonValue
    private final String text;


    BrowseTypeEnum(String text, int value) {
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
