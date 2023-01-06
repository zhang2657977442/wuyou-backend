package com.example.wuyou.controller;

import com.example.wuyou.common.BaseResponse;
import com.example.wuyou.common.PageRequest;
import com.example.wuyou.common.ResultUtils;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Industry;
import com.example.wuyou.service.IndustryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 行业信息;
 * @author : One Direction
 * @date : 2022-11-18
 */
@Api(tags = "行业信息管理")
@RestController
@RequestMapping("/industry")
public class IndustryController {
    @Autowired
    private IndustryService industryService;

    @ApiOperation(value = "获取行业列表")
    @PostMapping("/getIndustryList")
    public BaseResponse<PageListResponse<Industry>> getIndustryList(@RequestBody PageRequest params){
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<Industry> result = industryService.getIndustryList(current, pageSize);
        return ResultUtils.success(result);
    }

}
