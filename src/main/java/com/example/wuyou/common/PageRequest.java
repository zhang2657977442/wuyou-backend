package com.example.wuyou.common;

import com.example.wuyou.constant.CommonConstant;
import lombok.Data;

@Data
public class PageRequest {

    /**
     * 当前页号
     */
    private long current;

    /**
     * 页面大小
     */
    private long pageSize;

}
