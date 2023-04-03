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
import org.springframework.web.bind.annotation.*;


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
    @PostMapping("/getWelfareList")
    public BaseResponse<PageListResponse<Welfare>> getWelfareList(@RequestBody PageRequest params){
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<Welfare> result = welfareService.getWelfareList(current, pageSize);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "新增福利信息")
    @PostMapping("/addWelfare")
    public BaseResponse<Boolean> addWelfare(@RequestBody Welfare params){
        Boolean result = welfareService.addWelfare(params);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "更新福利信息")
    @PostMapping("/updateWelfare")
    public BaseResponse<Boolean> updateWelfare(@RequestBody Welfare params){
        Boolean result = welfareService.updateWelfare(params);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "删除福利信息")
    @DeleteMapping("/deleteWelfare/{id}")
    public BaseResponse<Boolean> deleteWelfare(@PathVariable("id") String id){
        Boolean result = welfareService.deleteWelfare(id);
        return ResultUtils.success(result);
    }

}
