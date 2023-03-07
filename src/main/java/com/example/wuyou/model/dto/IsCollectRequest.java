package com.example.wuyou.model.dto;

import com.example.wuyou.model.enums.CollectTypeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class IsCollectRequest implements Serializable {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 数据id
     */
    private String dataId;
    /**
     * 类型
     */
    private CollectTypeEnum type;
}
