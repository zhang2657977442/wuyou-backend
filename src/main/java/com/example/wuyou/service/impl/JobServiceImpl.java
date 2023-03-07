package com.example.wuyou.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.mapper.JobMapper;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Job;
import com.example.wuyou.model.vo.JobInfoVo;
import com.example.wuyou.service.JobService;
import com.example.wuyou.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobMapper jobMapper;

    public PageListResponse getJobList(long current, long pageSize, String jobName){
        // 分页查询
        Page<JobInfoVo> page = jobMapper.getJobList(new Page<>(current, pageSize), jobName);
        PageListResponse result = new PageListResponse();
        result.setList(page.getRecords());
        result.setTotal(page.getTotal());
        return result;
    }

    public Boolean updateJobInfo(Job params){
        int count = jobMapper.updateById(params);
        return count > 0;
    }

    public Boolean deleteJob(String id){
        int count = jobMapper.deleteById(id);
        return count > 0;
    }

    public Boolean addJob(Job params){
        // 生成uuid
        String id = new UuidUtils().getShortUuid();
        params.setId(id);
        int count = jobMapper.insert(params);
        return count > 0;
    }




}
