package com.example.wuyou.service;

import com.example.wuyou.model.dto.PageListResponse;

public interface CompanyService {

    PageListResponse getJobList(long current, long pageSize);
}
