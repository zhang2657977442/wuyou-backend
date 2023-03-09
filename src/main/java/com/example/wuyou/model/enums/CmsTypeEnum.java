package com.example.wuyou.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CmsTypeEnum {
    YHXY("用户协议", 0),
    YSZC("隐私政策", 1),
    GYWM("关于我们", 2),
    XTGG("系统公告", 3);
    @EnumValue
    private final int value;
    @JsonValue
    private final String text;


    CmsTypeEnum(String text, int value) {
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
