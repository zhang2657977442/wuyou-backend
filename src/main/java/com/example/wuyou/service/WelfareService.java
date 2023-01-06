package com.example.wuyou.service;

import com.example.wuyou.model.dto.PageListResponse;

public interface WelfareService {

    PageListResponse getWelfareList(long current, long pageSize);
}
