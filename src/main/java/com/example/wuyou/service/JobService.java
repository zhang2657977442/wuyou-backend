package com.example.wuyou.service;

import com.example.wuyou.model.dto.PageListResponse;

public interface JobService {

    PageListResponse getJobList(long current, long pageSize, String jobName);

}
