package com.example.wuyou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.wuyou.model.entity.User;
import com.example.wuyou.mapper.UserMapper;
import com.example.wuyou.service.UserService;
/**
 * 用户信息;(user)表服务实现类
 * @author : http://www.chiner.pro
 * @date : 2022-11-18
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    /**
     *
     * @return
     */
    public User getInfo(){
        return userMapper.getInfo();
    }
}
