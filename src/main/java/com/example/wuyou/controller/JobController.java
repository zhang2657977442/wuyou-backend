package com.example.wuyou.controller;

import com.example.wuyou.common.BaseResponse;
import com.example.wuyou.common.PageRequest;
import com.example.wuyou.common.ResultUtils;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.vo.JobInfoVo;
import com.example.wuyou.service.JobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 工作信息;
 * @author : One Direction
 * @date : 2022-11-18
 */
@Api(tags = "工作信息管理")
@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;

    @ApiOperation(value = "获取工作列表")
    @PostMapping("/getJobList")
    public BaseResponse<PageListResponse<JobInfoVo>> getJobList(@RequestBody PageRequest params){
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<JobInfoVo> result = jobService.getJobList(current, pageSize);
        return ResultUtils.success(result);
    }

}
