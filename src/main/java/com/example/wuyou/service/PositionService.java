package com.example.wuyou.service;

import com.example.wuyou.model.dto.PageListResponse;

public interface PositionService {

    PageListResponse getPostList(long current, long pageSize);
}
