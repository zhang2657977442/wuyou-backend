package com.example.wuyou.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.mapper.JobMapper;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Job;
import com.example.wuyou.model.entity.Resume;
import com.example.wuyou.model.vo.JobInfoVo;
import com.example.wuyou.service.JobService;
import com.example.wuyou.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobMapper jobMapper;
    // 根据名称搜索职位
    public PageListResponse getJobList(long current, long pageSize, String jobName){
        // 分页查询
        Page<JobInfoVo> page = jobMapper.getJobList(new Page<>(current, pageSize), jobName);
        PageListResponse result = new PageListResponse();
        // 获取列表
        result.setList(page.getRecords());
        // 获取总数
        result.setTotal(page.getTotal());
        return result;
    }

    // 更新职位信息
    public Boolean updateJobInfo(Job params){
        // 根据主键ID更新职位信息，返回更新成功个数
        int count = jobMapper.updateById(params);
        return count > 0;
    }
    // 删除职位
    public Boolean deleteJob(String id){
        int count = jobMapper.deleteById(id);
        return count > 0;
    }
    // 发布新职位
    public Boolean addJob(Job params){
        // 生成uuid
        String id = new UuidUtils().getShortUuid();
        // 设置职位ID
        params.setId(id);
        // 执行插入语句，返回插入成功个数
        int count = jobMapper.insert(params);
        return count > 0;
    }

}
