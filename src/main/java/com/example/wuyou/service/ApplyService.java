package com.example.wuyou.service;

import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.enums.ApplyTypeEnum;

public interface ApplyService {
    Boolean addApply(String userId, String dataId, ApplyTypeEnum type);

    Boolean deleteApply(String userId, String dataId, ApplyTypeEnum type);

    Boolean isApply(String userId, String dataId, ApplyTypeEnum type);

    PageListResponse getApplyList(long current, long pageSize, String userId, ApplyTypeEnum type);

}
