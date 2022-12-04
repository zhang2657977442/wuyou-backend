package com.example.wuyou.service.impl;

import static com.example.wuyou.constant.WXConfigConstant.CODE_URL;
import static com.example.wuyou.constant.WXConfigConstant.APP_ID;
import static com.example.wuyou.constant.WXConfigConstant.SECRET;

import com.alibaba.fastjson2.JSONObject;
import com.example.wuyou.model.enums.UserRoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.wuyou.model.entity.User;
import com.example.wuyou.model.dto.GetOpenIdResponse;
import com.example.wuyou.mapper.UserMapper;
import com.example.wuyou.service.UserService;
import com.example.wuyou.common.ErrorCode;
import com.example.wuyou.exception.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.example.wuyou.model.dto.GetOpenIdResponse;
/**
 * 用户信息;(user)表服务实现类
 * @author : One Direction
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
    public User getUserInfo(String id){
        return userMapper.getUserInfo(id);
    }

    public boolean switchRole(String id, String role){
        User user = userMapper.getUserInfo(id);
        // 用户不存在
        if (user == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户不存在");
        }
        // 判断用户当前的角色
        int roleValue = UserRoleEnum.valueSwitch(role);
        int userRole = userMapper.getUserInfo(id).getRole();
        if(roleValue != userRole){
            int total = userMapper.switchRole(id, roleValue);
            return total > 0;
        }else{
            return false;
        }
    }

    public GetOpenIdResponse getOpenId(String codeId){
        RestTemplate restTemplate = new RestTemplate();
        String url = CODE_URL + APP_ID +
                "&secret=" + SECRET +
                "&js_code=" + codeId +
                "&grant_type=authorization_code";

        ResponseEntity<String> res = restTemplate.getForEntity(url, String.class);
        JSONObject jsonObject = JSONObject.parseObject(res.getBody());
        Object openId = jsonObject.get("openid");
        // codeId已被使用
        if (openId == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "codeId已被使用");
        }
        GetOpenIdResponse result = new GetOpenIdResponse();
        result.setOpenid(jsonObject.get("openid").toString());
        result.setSession_key(jsonObject.get("session_key").toString());
        return result;
    }
}
