package com.example.wuyou.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.mapper.IndustryMapper;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Industry;
import com.example.wuyou.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndustryServiceImpl implements IndustryService {
    @Autowired
    private IndustryMapper industryMapper;


    public PageListResponse getIndustryList(long current, long pageSize){
        // 分页查询
        Page<Industry> page = industryMapper.selectPage(new Page<>(current, pageSize), null);
        PageListResponse result = new PageListResponse();
        result.setList(page.getRecords());
        result.setTotal(page.getTotal());
        return result;
    }
}
