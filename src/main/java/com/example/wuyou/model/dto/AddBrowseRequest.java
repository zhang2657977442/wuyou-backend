package com.example.wuyou.model.dto;

import com.example.wuyou.model.enums.BrowseTypeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class AddBrowseRequest implements Serializable {
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
    private BrowseTypeEnum type;
}
