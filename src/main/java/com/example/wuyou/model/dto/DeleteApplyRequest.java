package com.example.wuyou.model.dto;

import com.example.wuyou.model.enums.ApplyTypeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class DeleteApplyRequest implements Serializable {
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
    private ApplyTypeEnum type;
}
