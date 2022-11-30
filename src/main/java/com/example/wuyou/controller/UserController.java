package com.example.wuyou.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.wuyou.model.entity.User;
import com.example.wuyou.service.UserService;
import com.example.wuyou.common.BaseResponse;
import com.example.wuyou.common.ResultUtils;
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

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    @ApiOperation(value = "获取用户信息")
    @GetMapping("/getUserInfo")
    @ResponseBody
    public BaseResponse<User> getUserInfo(){
        User user = userService.getUserInfo();
        return ResultUtils.success(user);
    }

}
