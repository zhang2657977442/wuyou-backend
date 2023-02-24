package com.example.wuyou.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum VerifyStatusEnum {
    DSH("待审核", 0),
    SHTG("审核通过", 1),
    SHSB("审核失败", 2);

    @EnumValue
    private final int value;
    @JsonValue
    private final String text;


    VerifyStatusEnum(String text, int value) {
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
