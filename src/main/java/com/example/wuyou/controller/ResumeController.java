package com.example.wuyou.controller;

import com.example.wuyou.common.BaseResponse;
import com.example.wuyou.common.ResultUtils;
import com.example.wuyou.model.dto.WxUserLoginRequest;
import com.example.wuyou.model.dto.WxUserLoginResponse;
import com.example.wuyou.model.entity.Resume;
import com.example.wuyou.model.vo.UserInfoVo;
import com.example.wuyou.service.ResumeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 个人简历信息;
 * @author : One Direction
 * @date : 2022-11-18
 */
@Api(tags = "简历信息管理")
@RestController
@RequestMapping("/resume")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @ApiOperation(value = "获取简历信息")
    @GetMapping("/getResumeInfo")
    public BaseResponse<Resume> getResumeInfo(HttpServletRequest request) {
        String token = request.getHeader("token");// 从 http 请求头中取出 token
        Resume result = resumeService.getResumeInfo(token);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "更新简历信息")
    @PostMapping("/updateResume")
    public BaseResponse<Boolean> updateResume(@RequestBody Resume params){
        Boolean result = resumeService.updateResume(params);
        return ResultUtils.success(result);
    }

}
