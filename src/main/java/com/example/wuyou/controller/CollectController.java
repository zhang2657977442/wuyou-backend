package com.example.wuyou.controller;

import com.example.wuyou.common.BaseResponse;
import com.example.wuyou.common.ResultUtils;
import com.example.wuyou.model.dto.AddCollectRequest;
import com.example.wuyou.model.enums.CollectTypeEnum;
import com.example.wuyou.service.CollectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 收藏信息;
 * @author : One Direction
 * @date : 2022-11-18
 */
@Api(tags = "收藏信息管理")
@RestController
@RequestMapping("/collect")
public class CollectController {
    @Autowired
    private CollectService collectService;

    @ApiOperation(value = "新增收藏信息")
    @PostMapping("/addCollect")
    public BaseResponse<Boolean> addCollect(@RequestBody AddCollectRequest params){
        String userId =  params.getUserId();
        String jobId = params.getJobId();
        CollectTypeEnum type = params.getType();
        Boolean result = collectService.addCollect(userId, jobId, type);
        return ResultUtils.success(result);
    }

}

