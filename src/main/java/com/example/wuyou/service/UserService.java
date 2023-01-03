package com.example.wuyou.service;

import com.example.wuyou.model.entity.User;
import com.example.wuyou.model.dto.GetOpenIdResponse;
import com.example.wuyou.model.dto.WxUserLoginResponse;
/**
 * 用户信息;(user)表服务接口
 * @author : One Direction
 * @date : 2022-11-18
 */
public interface UserService{

    User getUserInfo(String token);

    GetOpenIdResponse getOpenId(String codeId);

    WxUserLoginResponse wxUserLogin(String openId, String username, String avatar);

    boolean switchRole(String id, String role);


}