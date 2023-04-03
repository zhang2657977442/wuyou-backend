package com.example.wuyou.service;

import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Welfare;

public interface WelfareService {

    PageListResponse getWelfareList(long current, long pageSize);

    Boolean deleteWelfare(String id);

    Boolean addWelfare(Welfare params);

    Boolean updateWelfare(Welfare params);
}
