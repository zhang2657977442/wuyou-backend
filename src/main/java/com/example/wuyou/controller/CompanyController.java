package com.example.wuyou.controller;

import com.example.wuyou.common.BaseResponse;
import com.example.wuyou.common.PageRequest;
import com.example.wuyou.common.ResultUtils;
import com.example.wuyou.model.dto.GetCompanyJobRequest;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Company;
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
    private CompanyService companyService;

    @ApiOperation(value = "获取公司列表")
    @PostMapping("/getCompanyList")
    public BaseResponse<PageListResponse<CompanyInfoVo>> getCompanyList(@RequestBody PageRequest params){
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<CompanyInfoVo> result = companyService.getCompanyList(current, pageSize);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "获取公司职位")
    @PostMapping("/getCompanyJob")
    public BaseResponse<PageListResponse<JobInfoVo>> getCompanyJob(@RequestBody GetCompanyJobRequest params){
        String id =  params.getId();
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<JobInfoVo> result = companyService.getCompanyJob(id,current, pageSize);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "获取公司信息")
    @GetMapping("/getCompanyInfo/{id}")
    public BaseResponse<CompanyInfoVo> getCompanyInfo(@PathVariable("id") String id){
        CompanyInfoVo result = companyService.getCompanyInfo(id);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "更新公司信息")
    @PostMapping("/updateCompanyInfo")
    public BaseResponse<Boolean> updateCompanyInfo(@RequestBody Company params){
        Boolean result = companyService.updateCompanyInfo(params);
        return ResultUtils.success(result);
    }

}
