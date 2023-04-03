package com.example.wuyou.service;

import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Industry;

public interface IndustryService {

    PageListResponse getIndustryList(long current, long pageSize);

    Boolean deleteIndustry(String id);

    Boolean addIndustry(Industry params);

    Boolean updateIndustry(Industry params);
}
