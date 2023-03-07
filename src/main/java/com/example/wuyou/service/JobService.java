package com.example.wuyou.service;

import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Job;

public interface JobService {

    PageListResponse getJobList(long current, long pageSize, String jobName);

    Boolean updateJobInfo(Job params);

    Boolean deleteJob(String id);

    Boolean addJob(Job params);

}
