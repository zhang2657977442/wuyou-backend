package com.example.wuyou.controller;

import com.example.wuyou.common.BaseResponse;
import com.example.wuyou.common.PageRequest;
import com.example.wuyou.common.ResultUtils;
import com.example.wuyou.model.dto.GetResumeListRequest;
import com.example.wuyou.model.entity.Resume;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Welfare;
import com.example.wuyou.model.vo.ResumeVo;
import com.example.wuyou.service.ResumeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "获取用户简历")
    @GetMapping("/getUserResume")
    public BaseResponse<Resume> getUserResume(HttpServletRequest request) {
        String token = request.getHeader("token");// 从 http 请求头中取出 token
        Resume result = resumeService.getUserResume(token);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "更新简历信息")
    @PostMapping("/updateResumeInfo")
    public BaseResponse<Boolean> updateResume(@RequestBody Resume params){
        Boolean result = resumeService.updateResume(params);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "获取简历列表")
    @PostMapping("/getResumeList")
    public BaseResponse<PageListResponse<ResumeVo>> getResumeList(@RequestBody GetResumeListRequest params){
        String keyword = params.getKeyword();
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<ResumeVo> result = resumeService.getResumeList(current, pageSize, keyword);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "获取简历信息")
    @GetMapping("/getResumeInfo/{id}")
    public BaseResponse<ResumeVo> getResumeInfo(@PathVariable("id") String id) {
        ResumeVo result = resumeService.getResumeInfo(id);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "新增简历信息")
    @PostMapping("/addResume")
    public BaseResponse<Boolean> addResume(@RequestBody Resume params){
        Boolean result = resumeService.addResume(params);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "删除简历信息")
    @DeleteMapping("/deleteResume/{id}")
    public BaseResponse<Boolean> deleteResume(@PathVariable("id") String id){
        Boolean result = resumeService.deleteResume(id);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "管理员获取简历列表")
    @PostMapping("/getList")
    public BaseResponse<PageListResponse<Resume>> getList(@RequestBody PageRequest params){
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<Resume> result = resumeService.getList(current, pageSize);
        return ResultUtils.success(result);
    }

}
