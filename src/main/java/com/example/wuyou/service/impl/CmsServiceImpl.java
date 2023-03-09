package com.example.wuyou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.mapper.CmsMapper;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Cms;
import com.example.wuyou.model.enums.CmsTypeEnum;
import com.example.wuyou.service.CmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CmsServiceImpl implements CmsService {
    @Autowired
    private CmsMapper cmsMapper;


    public PageListResponse getCmsList(long current, long pageSize, CmsTypeEnum type){
        // 分页查询
        QueryWrapper<Cms> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", type);
        Page<Cms> page = cmsMapper.selectPage(new Page<>(current, pageSize), queryWrapper);
        PageListResponse result = new PageListResponse();
        result.setList(page.getRecords());
        result.setTotal(page.getTotal());
        return result;
    }
}
