package com.example.wuyou.model.dto;

import com.example.wuyou.common.PageRequest;
import com.example.wuyou.model.enums.BrowseTypeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class GetBrowseListRequest extends PageRequest implements Serializable {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 类型
     */
    private BrowseTypeEnum type;
}
