package com.example.wuyou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.common.ErrorCode;
import com.example.wuyou.config.JwtConfig;
import com.example.wuyou.exception.BusinessException;
import com.example.wuyou.mapper.ResumeMapper;
import com.example.wuyou.model.entity.Resume;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.vo.ResumeVo;
import com.example.wuyou.service.ResumeService;
import com.example.wuyou.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 个人简历信息;(person_resume)表服务实现类
 * @author : One Direction
 * @date : 2022-12-13
 */
@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeMapper resumeMapper;

    public Resume getUserResume(String token){
        String id = JwtConfig.getTokenInfo(token).getClaim("id").asString();
        // 判断是否存在该简历
        QueryWrapper<Resume> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", id);
        Resume result = resumeMapper.selectOne(queryWrapper);
        if(result == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "暂无数据");
        }
        return result;
    }

    public Boolean updateResume(Resume params){
         int count = resumeMapper.updateById(params);
         return count > 0;
    }

    public PageListResponse getResumeList(long current, long pageSize, String keyword){
        // 分页查询
        Page<ResumeVo> page = resumeMapper.getResumeList(new Page<>(current, pageSize), keyword);
        PageListResponse result = new PageListResponse();
        result.setList(page.getRecords());
        result.setTotal(page.getTotal());
        return result;
    }

    public ResumeVo getResumeInfo(String id){
        ResumeVo result = resumeMapper.getResumeInfo(id);
        if(result == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "暂无数据");
        }
        return result;
    }

    public Boolean addResume(Resume params){
        // 生成uuid
        String id = new UuidUtils().getShortUuid();
        params.setId(id);
        int count = resumeMapper.insert(params);
        return count > 0;
    }
}
