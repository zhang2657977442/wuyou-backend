package com.example.wuyou.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ExperienceEnum {
    BX("不限", 0),
    ONE("1年以内", 1),
    THREE("1-3年", 2),
    FIVE("3-5年", 3),
    TEN("5-10年", 4),
    TENS("10年以上", 5);

    @EnumValue
    private final int value;
    @JsonValue
    private final String text;


    ExperienceEnum(String text, int value) {
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
