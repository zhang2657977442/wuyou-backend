package com.example.wuyou.controller;

import com.example.wuyou.common.BaseResponse;
import com.example.wuyou.common.ResultUtils;
import com.example.wuyou.model.dto.AddBrowseRequest;
import com.example.wuyou.model.enums.BrowseTypeEnum;
import com.example.wuyou.service.BrowseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
        String jobId = params.getJobId();
        BrowseTypeEnum type = params.getType();
        Boolean result = browseService.addBrowse(userId, jobId, type);
        return ResultUtils.success(result);
    }
}

