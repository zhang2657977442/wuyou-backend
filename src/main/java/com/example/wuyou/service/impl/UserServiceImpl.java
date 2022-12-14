package com.example.wuyou.service.impl;

import static com.example.wuyou.constant.WXConfigConstant.CODE_URL;
import static com.example.wuyou.constant.WXConfigConstant.APP_ID;
import static com.example.wuyou.constant.WXConfigConstant.SECRET;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.alibaba.fastjson2.JSONObject;
import com.example.wuyou.model.enums.UserRoleEnum;
import com.example.wuyou.model.entity.User;
import com.example.wuyou.model.dto.GetOpenIdResponse;
import com.example.wuyou.model.dto.WxUserLoginResponse;
import com.example.wuyou.mapper.UserMapper;
import com.example.wuyou.service.UserService;
import com.example.wuyou.common.ErrorCode;
import com.example.wuyou.exception.BusinessException;
import com.example.wuyou.config.JwtConfig;
import com.example.wuyou.utils.UuidUtils;


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
    public User getUserInfo(String token){
        String id = JwtConfig.getTokenInfo(token).getClaim("id").asString();
        return userMapper.selectById(id);
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
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "codeId已失效");
        }
        GetOpenIdResponse result = new GetOpenIdResponse();
        result.setOpenid(jsonObject.get("openid").toString());
        result.setSession_key(jsonObject.get("session_key").toString());
        return result;
    }

    public WxUserLoginResponse wxUserLogin(String openId, String username, String avatar) {
        // 判断是否存在该用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("open_id", openId);
        User userInfo = userMapper.selectOne(queryWrapper);
        String id = null;
        // 用户不存在插入数据库
        if (userInfo == null) {
            User user = new User();
            id = new UuidUtils().getShortUuid();
            user.setId(id);
            user.setOpenId(openId);
            user.setUsername(username);
            user.setAvatar(avatar);
            userMapper.insert(user);
        }else{
          id = userInfo.getId();
        }
        String token = JwtConfig.sign(openId, id);
        WxUserLoginResponse result = new WxUserLoginResponse();
        result.setToken(token);
        return result;
    }

    public boolean switchRole(String id, String role){
        User user = userMapper.selectById(id);
        // 用户不存在
        if (user == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户不存在");
        }
        // 判断用户当前的角色
        UserRoleEnum roleValue = UserRoleEnum.valueOf(role);
        UserRoleEnum userRole = userMapper.selectById(id).getRole();
        if(roleValue != userRole){
            User updateRole = new User();
            updateRole.setId(id);
            updateRole.setRole(roleValue);
            int total = userMapper.updateById(updateRole);
            return total > 0;
        }else{
            throw new BusinessException(ErrorCode.OPERATION_ERROR);
        }
    }


}
