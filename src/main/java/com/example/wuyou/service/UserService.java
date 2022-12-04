package com.example.wuyou.service;

import com.example.wuyou.model.entity.User;
import com.example.wuyou.model.dto.GetOpenIdResponse;
/**
 * 用户信息;(user)表服务接口
 * @author : One Direction
 * @date : 2022-11-18
 */
public interface UserService{
    /**
     *
     * @return 实例对象
     */
    User getUserInfo(String id);

    boolean switchRole(String id, String role);

    GetOpenIdResponse getOpenId(String codeId);
}