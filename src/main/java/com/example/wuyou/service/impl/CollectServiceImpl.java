package com.example.wuyou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.common.ErrorCode;
import com.example.wuyou.exception.BusinessException;
import com.example.wuyou.mapper.CollectMapper;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Collect;
import com.example.wuyou.model.enums.CollectTypeEnum;
import com.example.wuyou.model.vo.JobInfoVo;
import com.example.wuyou.model.vo.ResumeVo;
import com.example.wuyou.service.CollectService;
import com.example.wuyou.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;

    public Boolean addCollect(String userId, String dataId, CollectTypeEnum type){
        Collect collect = new Collect();
        String id = new UuidUtils().getShortUuid();
        collect.setId(id);
        collect.setType(type);
        collect.setUserId(userId);
        collect.setDataId(dataId);
        int result = collectMapper.insert(collect);
        if(result > 0){
            return result > 0;
        }else{
            throw new BusinessException(ErrorCode.OPERATION_ERROR);
        }
    }

    public Boolean deleteCollect(String userId, String dataId, CollectTypeEnum type){
        Collect collect = new Collect();
        collect.setType(type);
        collect.setUserId(userId);
        collect.setDataId(dataId);
        QueryWrapper<Collect> wrapper=new QueryWrapper<>(collect);
        int result = collectMapper.delete(wrapper);
        if(result > 0){
            return result > 0;
        }else{
            throw new BusinessException(ErrorCode.OPERATION_ERROR);
        }
    }

    public Boolean isCollect(String userId, String dataId, CollectTypeEnum type){
        Collect collect = new Collect();
        collect.setType(type);
        collect.setUserId(userId);
        collect.setDataId(dataId);
        QueryWrapper<Collect> wrapper=new QueryWrapper<>(collect);
        Collect result = collectMapper.selectOne(wrapper);
        if(result == null){
            return false;
        }else{
            return true;
        }
    }

    public PageListResponse getCollectList(long current, long pageSize, String userId, CollectTypeEnum type){
        // 分类查询
        if(type == CollectTypeEnum.SCGW){
            Page<JobInfoVo> page = collectMapper.getSCGWList(new Page<>(current, pageSize), userId, type);
            PageListResponse result = new PageListResponse();
            result.setList(page.getRecords());
            result.setTotal(page.getTotal());
            return result;
        }else if(type == CollectTypeEnum.SCJL){
            Page<ResumeVo> page = collectMapper.getSCJLList(new Page<>(current, pageSize), userId, type);
            PageListResponse result = new PageListResponse();
            result.setList(page.getRecords());
            result.setTotal(page.getTotal());
            return result;
        }else{
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
    }


}
