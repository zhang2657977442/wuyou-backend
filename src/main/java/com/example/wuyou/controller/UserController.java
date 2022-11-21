package com.example.wuyou.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.wuyou.model.entity.User;
import com.example.wuyou.service.UserService;

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
    @ApiOperation(value = "get接口传参")
    @GetMapping("/get")
    public ResponseEntity<User> getInfo(){
        return ResponseEntity.ok(userService.getInfo());
    }

}
