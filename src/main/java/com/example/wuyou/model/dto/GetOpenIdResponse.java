package com.example.wuyou.model.dto;

import java.io.Serializable;
import lombok.Data;
@Data
public class GetOpenIdResponse implements Serializable {
    /**
     * id
     */
    private String openid;

    /**
     * 角色
     */
    private String session_key;
}
