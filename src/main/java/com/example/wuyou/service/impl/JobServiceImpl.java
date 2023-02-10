package com.example.wuyou.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.mapper.JobMapper;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.vo.JobInfoVo;
import com.example.wuyou.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobMapper jobMapper;

    public PageListResponse getJobList(long current, long pageSize){
        // 分页查询
        Page<JobInfoVo> page = jobMapper.selectJobPage(new Page<>(current, pageSize));
        PageListResponse result = new PageListResponse();
        result.setList(page.getRecords());
        result.setTotal(page.getTotal());
        return result;
    }




}
