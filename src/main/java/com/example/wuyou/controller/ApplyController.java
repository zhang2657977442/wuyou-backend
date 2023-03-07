package com.example.wuyou.controller;

import com.example.wuyou.common.BaseResponse;
import com.example.wuyou.common.ResultUtils;
import com.example.wuyou.model.dto.*;
import com.example.wuyou.model.enums.ApplyTypeEnum;
import com.example.wuyou.service.ApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 应聘信息;
 * @author : One Direction
 * @date : 2022-11-18
 */
@Api(tags = "应聘信息管理")
@RestController
@RequestMapping("/apply")
public class ApplyController {
    @Autowired
    private ApplyService applyService;

    @ApiOperation(value = "新增应聘信息")
    @PostMapping("/addApply")
    public BaseResponse<Boolean> addApply(@RequestBody AddApplyRequest params){
        String userId =  params.getUserId();
        String jobId = params.getDataId();
        ApplyTypeEnum type = params.getType();
        Boolean result = applyService.addApply(userId, jobId, type);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "删除应聘信息")
    @PostMapping("/deleteApply")
    public BaseResponse<Boolean> deleteApply(@RequestBody DeleteApplyRequest params){
        String userId =  params.getUserId();
        String dataId = params.getDataId();
        ApplyTypeEnum type = params.getType();
        Boolean result = applyService.deleteApply(userId, dataId, type);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "是否应聘")
    @PostMapping("/isApply")
    public BaseResponse<Boolean> isApply(@RequestBody IsApplyRequest params){
        String userId =  params.getUserId();
        String dataId = params.getDataId();
        ApplyTypeEnum type = params.getType();
        Boolean result = applyService.isApply(userId, dataId, type);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "获取应聘信息")
    @PostMapping("/getApplyList")
    public <T> T getApplyList(@RequestBody GetApplyListRequest params){
        String userId = params.getUserId();
        ApplyTypeEnum type = params.getType();
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<T> result = applyService.getApplyList(current, pageSize, userId, type);
        return (T) ResultUtils.success(result);
    }


}
