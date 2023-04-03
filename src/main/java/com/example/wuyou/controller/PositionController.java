package com.example.wuyou.controller;

import com.example.wuyou.common.BaseResponse;
import com.example.wuyou.common.PageRequest;
import com.example.wuyou.common.ResultUtils;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Position;
import com.example.wuyou.service.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 职位信息;
 * @author : One Direction
 * @date : 2022-11-18
 */
@Api(tags = "职位信息管理")
@RestController
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @ApiOperation(value = "获取岗位列表")
    @PostMapping("/getPositionList")
    public BaseResponse<PageListResponse<Position>> getPositionList(@RequestBody PageRequest params){
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<Position> result = positionService.getPositionList(current, pageSize);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "新增岗位信息")
    @PostMapping("/addPosition")
    public BaseResponse<Boolean> addPosition(@RequestBody Position params){
        Boolean result = positionService.addPosition(params);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "更新岗位信息")
    @PostMapping("/updatePosition")
    public BaseResponse<Boolean> updatePosition(@RequestBody Position params){
        Boolean result = positionService.updatePosition(params);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "删除岗位信息")
    @DeleteMapping("/deletePosition/{id}")
    public BaseResponse<Boolean> deletePosition(@PathVariable("id") String id){
        Boolean result = positionService.deletePosition(id);
        return ResultUtils.success(result);
    }

}
