package com.example.wuyou.service;

import com.example.wuyou.model.dto.PageListResponse;

public interface PositionService {

    PageListResponse getPositionList(long current, long pageSize);
}
