package com.example.wuyou.model.dto;

import com.example.wuyou.model.enums.CollectTypeEnum;
import lombok.Data;
import java.io.Serializable;

@Data
public class AddCollectRequest implements Serializable {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 工作id
     */
    private String jobId;
    /**
     * 类型
     */
    private CollectTypeEnum type;
}
