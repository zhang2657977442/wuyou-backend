package com.example.wuyou.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginResponse implements Serializable{
    /**
     * token
     */
    private String token;
}
