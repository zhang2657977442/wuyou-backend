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
     * 数据id
     */
    private String dataId;
    /**
     * 类型
     */
    private BrowseTypeEnum type;
}
