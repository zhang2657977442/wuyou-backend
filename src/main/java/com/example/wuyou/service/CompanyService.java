package com.example.wuyou.service;

import com.example.wuyou.model.dto.PageListResponse;

public interface CompanyService {

    PageListResponse getCompanyList(long current, long pageSize);
}
