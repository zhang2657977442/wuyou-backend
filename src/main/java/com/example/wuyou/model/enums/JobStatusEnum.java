package com.example.wuyou.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum JobStatusEnum {
    ZBKL("在职-暂不考虑", 0),
    KLJH("在职-考虑机会", 1),
    YDDG("在职-月内到岗", 2),
    SSDG("离职-随时到岗", 3);

    @EnumValue
    private final int value;
    @JsonValue
    private final String text;


    JobStatusEnum(String text, int value) {
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
