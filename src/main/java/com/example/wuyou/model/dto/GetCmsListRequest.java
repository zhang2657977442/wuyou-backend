package com.example.wuyou.model.dto;

import com.example.wuyou.common.PageRequest;
import com.example.wuyou.model.enums.CmsTypeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class GetCmsListRequest extends PageRequest implements Serializable {
    /**
     * 类型
     */
    private CmsTypeEnum type;
}
