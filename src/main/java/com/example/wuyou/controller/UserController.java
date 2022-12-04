package com.example.wuyou.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;
import com.example.wuyou.service.UserService;
import com.example.wuyou.model.vo.UserInfoVo;
import com.example.wuyou.model.dto.SwitchRoleRequest;
import com.example.wuyou.model.dto.GetOpenIdResponse;
import com.example.wuyou.model.entity.User;
import com.example.wuyou.common.BaseResponse;
import com.example.wuyou.common.ResultUtils;
import com.example.wuyou.common.ErrorCode;
import com.example.wuyou.exception.BusinessException;
/**
 * 用户信息;(user)表控制层
 * @author : One Direction
 * @date : 2022-11-18
 */
@Api(tags = "用户账户管理")
@RestController
@RequestMapping("/user")
public class UserController{
    @Autowired
    private UserService userService;


    @ApiOperation(value = "获取用户信息")
    @GetMapping("/getUserInfo{id}")
    public BaseResponse<UserInfoVo> getUserInfo(String id) {
        User result = userService.getUserInfo(id);
        UserInfoVo UserInfoVo = new UserInfoVo();
        BeanUtils.copyProperties(result, UserInfoVo);
        return ResultUtils.success(UserInfoVo);
    }

    @ApiOperation(value = "切换用户角色")
    @PostMapping("/switchRole")
    public BaseResponse<Boolean> switchRole(@RequestBody SwitchRoleRequest switchRoleRequest){
        String id = switchRoleRequest.getId();
        String role = switchRoleRequest.getRole();
        boolean result = userService.switchRole(id, role);
        if (!result) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR);
        }
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "获取用户OpenId")
    @GetMapping("/getOpenId{code}")
    public BaseResponse<GetOpenIdResponse> getOpenId(String codeId){
        GetOpenIdResponse result = userService.getOpenId(codeId);
        return ResultUtils.success(result);
    }

}
