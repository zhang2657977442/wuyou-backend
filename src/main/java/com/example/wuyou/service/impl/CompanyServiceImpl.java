package com.example.wuyou.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.mapper.CompanyMapper;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.vo.CompanyInfoVo;
import com.example.wuyou.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    public PageListResponse getCompanyList(long current, long pageSize){
        // 分页查询
        Page<CompanyInfoVo> page = companyMapper.selectCompanyPage(new Page<>(current, pageSize));
        PageListResponse result = new PageListResponse();
        result.setList(page.getRecords());
        result.setTotal(page.getTotal());
        return result;
    }
}
