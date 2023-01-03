package com.example.wuyou.model.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class WxUserLoginResponse implements Serializable{
    /**
     * token
     */
    private String token;
}
