package com.example.wuyou.controller;

import com.example.wuyou.common.BaseResponse;
import com.example.wuyou.common.PageRequest;
import com.example.wuyou.common.ResultUtils;
import com.example.wuyou.model.dto.GetCompanyJobRequest;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.vo.CompanyInfoVo;
import com.example.wuyou.model.vo.JobInfoVo;
import com.example.wuyou.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 公司信息;
 * @author : One Direction
 * @date : 2022-11-18
 */
@Api(tags = "公司信息管理")
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService CompanyService;

    @ApiOperation(value = "获取公司列表")
    @PostMapping("/getCompanyList")
    public BaseResponse<PageListResponse<CompanyInfoVo>> getCompanyList(@RequestBody PageRequest params){
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<CompanyInfoVo> result = CompanyService.getCompanyList(current, pageSize);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "获取公司职位")
    @PostMapping("/getCompanyJob")
    public BaseResponse<PageListResponse<JobInfoVo>> getCompanyJob(@RequestBody GetCompanyJobRequest params){
        String id =  params.getId();
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<JobInfoVo> result = CompanyService.getCompanyJob(id,current, pageSize);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "获取公司信息")
    @GetMapping("/getCompanyInfo/{id}")
    public BaseResponse<CompanyInfoVo> getCompanyInfo(@PathVariable("id") String id){
        CompanyInfoVo result = CompanyService.getCompanyInfo(id);
        return ResultUtils.success(result);
    }

}
