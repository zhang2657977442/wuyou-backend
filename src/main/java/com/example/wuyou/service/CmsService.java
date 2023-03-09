package com.example.wuyou.service;

import com.example.wuyou.model.enums.CmsTypeEnum;
import com.example.wuyou.model.dto.PageListResponse;

public interface CmsService {

    PageListResponse getCmsList(long current, long pageSize, CmsTypeEnum type);
}
