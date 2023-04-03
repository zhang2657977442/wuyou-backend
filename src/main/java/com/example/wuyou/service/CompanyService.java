package com.example.wuyou.service;

import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Company;
import com.example.wuyou.model.vo.CompanyInfoVo;

public interface CompanyService {

    PageListResponse getCompanyList(long current, long pageSize);

    PageListResponse getCompanyJob(String id,long current, long pageSize);

    CompanyInfoVo getCompanyInfo(String id);

    Boolean updateCompanyInfo(Company params);

    Boolean addCompanyInfo(Company params);

    Boolean deleteCompany(String id);

    Boolean addCompany(Company params,String token);
}
