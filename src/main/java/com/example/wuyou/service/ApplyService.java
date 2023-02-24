package com.example.wuyou.service;

import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.enums.ApplyTypeEnum;

public interface ApplyService {
    Boolean addApply(String userId, String jobId, ApplyTypeEnum type);

}
