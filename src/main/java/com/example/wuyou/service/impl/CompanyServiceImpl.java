package com.example.wuyou.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.mapper.CompanyJobMapper;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.CompanyJob;
import com.example.wuyou.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyJobMapper companyJobMapper;


    public PageListResponse getJobList(long current, long pageSize){
        // 分页查询
        Page<CompanyJob> page = companyJobMapper.selectPage(new Page<>(current, pageSize), null);
        PageListResponse result = new PageListResponse();
        result.setList(page.getRecords());
        result.setTotal(page.getTotal());
        return result;
    }
}
