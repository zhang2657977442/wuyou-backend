package com.example.wuyou.controller;

import com.example.wuyou.common.BaseResponse;
import com.example.wuyou.common.ResultUtils;
import com.example.wuyou.model.dto.GetJobListRequest;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Job;
import com.example.wuyou.model.vo.JobInfoVo;
import com.example.wuyou.service.JobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    @ApiOperation(value = "新增工作信息")
    @PostMapping("/addJob")
    public BaseResponse<Boolean> addJob(@RequestBody Job params){
        Boolean result = jobService.addJob(params);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "获取工作列表")
    @PostMapping("/getJobList")
    public BaseResponse<PageListResponse<JobInfoVo>> getJobList(@RequestBody GetJobListRequest params){
        String jobName = params.getJobName();
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<JobInfoVo> result = jobService.getJobList(current, pageSize, jobName);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "更新工作信息")
    @PostMapping("/updateJobInfo")
    public BaseResponse<Boolean> updateJobInfo(@RequestBody Job params){
        Boolean result = jobService.updateJobInfo(params);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "删除工作信息")
    @DeleteMapping("/deleteJob/{id}")
    public BaseResponse<Boolean> deleteJob(@PathVariable("id") String id){
        Boolean result = jobService.deleteJob(id);
        return ResultUtils.success(result);
    }

}
