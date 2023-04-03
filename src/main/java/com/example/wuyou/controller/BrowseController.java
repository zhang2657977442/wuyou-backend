package com.example.wuyou.controller;

import com.example.wuyou.common.BaseResponse;
import com.example.wuyou.common.ResultUtils;
import com.example.wuyou.model.dto.*;
import com.example.wuyou.model.enums.BrowseTypeEnum;
import com.example.wuyou.service.BrowseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 浏览信息;
 * @author : One Direction
 * @date : 2022-11-18
 */
@Api(tags = "浏览信息管理")
@RestController
@RequestMapping("/browse")
public class BrowseController {
    @Autowired
    private BrowseService browseService;

    @ApiOperation(value = "新增浏览信息")
    @PostMapping("/addBrowse")
    public BaseResponse<Boolean> addBrowse(@RequestBody AddBrowseRequest params){
        String userId =  params.getUserId();
        String dataId = params.getDataId();
        BrowseTypeEnum type = params.getType();
        Boolean result = browseService.addBrowse(userId, dataId, type);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "获取浏览信息")
    @PostMapping("/getBrowseList")
    public <T> T getBrowseList(@RequestBody GetBrowseListRequest params){
        String userId = params.getUserId();
        BrowseTypeEnum type = params.getType();
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<T> result = browseService.getBrowseList(current, pageSize, userId, type);
        return (T) ResultUtils.success(result);
    }

    @ApiOperation(value = "删除浏览信息")
    @DeleteMapping("/deleteBrowse/{id}")
    public BaseResponse<Boolean> deleteBrowse(@PathVariable("id") String id){
        Boolean result = browseService.deleteBrowse(id);
        return ResultUtils.success(result);
    }
}

