package com.example.wuyou.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.mapper.WelfareMapper;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Welfare;
import com.example.wuyou.service.WelfareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WelfareServiceImpl implements WelfareService {
    @Autowired
    private WelfareMapper welfareMapper;


    public PageListResponse getWelfareList(long current, long pageSize){
        // 分页查询
        Page<Welfare> page = welfareMapper.selectPage(new Page<>(current, pageSize), null);
        PageListResponse result = new PageListResponse();
        result.setList(page.getRecords());
        result.setTotal(page.getTotal());
        return result;
    }
}
