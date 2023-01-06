package com.example.wuyou.service;

import com.example.wuyou.model.dto.PageListResponse;

public interface IndustryService {

    PageListResponse getIndustryList(long current, long pageSize);
}
