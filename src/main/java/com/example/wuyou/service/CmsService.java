package com.example.wuyou.service;

import com.example.wuyou.model.entity.Cms;
import com.example.wuyou.model.enums.CmsTypeEnum;
import com.example.wuyou.model.dto.PageListResponse;

public interface CmsService {

    PageListResponse getCmsList(long current, long pageSize, CmsTypeEnum type);

    Boolean deleteCms(String id);

    Boolean addCms(Cms params);

    Boolean updateCms(Cms params);
}
