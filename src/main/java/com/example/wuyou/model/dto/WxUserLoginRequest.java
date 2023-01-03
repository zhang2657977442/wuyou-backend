package com.example.wuyou.model.dto;

import java.io.Serializable;
import lombok.Data;
@Data
public class WxUserLoginRequest implements Serializable {
    /**
     * openid
     */
    private String openid;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 名称
     */
    private String nickName;
}
