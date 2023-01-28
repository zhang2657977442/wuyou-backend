package com.example.wuyou.controller;

import com.example.wuyou.common.BaseResponse;
import com.example.wuyou.common.PageRequest;
import com.example.wuyou.common.ResultUtils;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.CompanyJob;
import com.example.wuyou.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 公司相关信息;
 * @author : One Direction
 * @date : 2022-11-18
 */
@Api(tags = "公司相关信息")
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService CompanyService;

    @ApiOperation(value = "获取公司职位")
    @PostMapping("/getJobList")
    public BaseResponse<PageListResponse<CompanyJob>> getJobList(@RequestBody PageRequest params){
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<CompanyJob> result = CompanyService.getJobList(current, pageSize);
        return ResultUtils.success(result);
    }

}
