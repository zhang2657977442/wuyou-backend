package com.example.wuyou.model.enums;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum UserRoleEnum {
    DEFAULT("求职者", 0),
    BOSS("招聘者", 1);

    private final String text;

    private final int value;

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

    public static int valueSwitch(String text){
        int result = 0;
        switch (text){
            case "DEFAULT":
                result = DEFAULT.getValue();
                break;
            case "BOSS":
                result = BOSS.getValue();
                break;
            default:
                break;
        }
        return result;
    }


}
