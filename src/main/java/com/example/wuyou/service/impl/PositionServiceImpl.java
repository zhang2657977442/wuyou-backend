package com.example.wuyou.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.mapper.PositionMapper;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Position;
import com.example.wuyou.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionMapper postMapper;


    public PageListResponse getPostList(long current, long pageSize){
        // 分页查询
        Page<Position> page = postMapper.selectPage(new Page<>(current, pageSize), null);
        PageListResponse result = new PageListResponse();
        result.setList(page.getRecords());
        result.setTotal(page.getTotal());
        return result;
    }
}
