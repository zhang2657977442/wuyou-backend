package com.example.wuyou.controller;

import com.example.wuyou.common.BaseResponse;
import com.example.wuyou.common.PageRequest;
import com.example.wuyou.common.ResultUtils;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Welfare;
import com.example.wuyou.service.WelfareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 福利信息;
 * @author : One Direction
 * @date : 2022-11-18
 */
@Api(tags = "福利信息管理")
@RestController
@RequestMapping("/welfare")
public class WelfareController {
    @Autowired
    private WelfareService welfareService;

    @ApiOperation(value = "获取福利列表")
    @PostMapping("/getIndustryList")
    public BaseResponse<PageListResponse<Welfare>> getWelfareList(@RequestBody PageRequest params){
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<Welfare> result = welfareService.getWelfareList(current, pageSize);
        return ResultUtils.success(result);
    }

}
