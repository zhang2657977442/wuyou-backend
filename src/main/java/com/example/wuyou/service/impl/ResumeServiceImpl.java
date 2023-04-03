package com.example.wuyou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.common.ErrorCode;
import com.example.wuyou.config.JwtConfig;
import com.example.wuyou.exception.BusinessException;
import com.example.wuyou.mapper.ResumeMapper;
import com.example.wuyou.model.entity.Resume;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Welfare;
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
    // 获取求职者简历信息
    public Resume getUserResume(String token){
        // 根据token获取用户ID
        String id = JwtConfig.getTokenInfo(token).getClaim("id").asString();
        // 查询数据库中是否已存在该用户的简历信息
        QueryWrapper<Resume> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", id);
        Resume result = resumeMapper.selectOne(queryWrapper);
        // 如果不存在返回暂无数据
        if(result == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "暂无数据");
        }
        // 如果存在返回查询结果
        return result;
    }
    // 更新简历信息
    public Boolean updateResume(Resume params){
        // 根据主键ID更新简历信息，返回更新成功个数
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
    // 创建新的简历信息
    public Boolean addResume(Resume params){
        // 生成uuid
        String id = new UuidUtils().getShortUuid();
        // 设置简历ID
        params.setId(id);
        // 执行插入语句，返回插入成功个数
        int count = resumeMapper.insert(params);
        return count > 0;
    }

    // 删除简历信息
    public Boolean deleteResume(String id){
        int count = resumeMapper.deleteById(id);
        return count > 0;
    }

    // 管理员获取简历列表
    public PageListResponse getList(long current, long pageSize){
        // 分页查询
        Page<Resume> page = resumeMapper.selectPage(new Page<>(current, pageSize), null);
        PageListResponse result = new PageListResponse();
        result.setList(page.getRecords());
        result.setTotal(page.getTotal());
        return result;
    }
}
