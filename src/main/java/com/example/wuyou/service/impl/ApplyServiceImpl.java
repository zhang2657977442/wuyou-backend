package com.example.wuyou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.common.ErrorCode;
import com.example.wuyou.exception.BusinessException;
import com.example.wuyou.mapper.ApplyMapper;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Apply;
import com.example.wuyou.model.enums.ApplyTypeEnum;
import com.example.wuyou.model.vo.JobInfoVo;
import com.example.wuyou.model.vo.ResumeVo;
import com.example.wuyou.service.ApplyService;
import com.example.wuyou.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    private ApplyMapper applyMapper;

    public Boolean addApply(String userId, String dataId, ApplyTypeEnum type){
        Apply apply = new Apply();
        String id = new UuidUtils().getShortUuid();
        apply.setId(id);
        apply.setType(type);
        apply.setUserId(userId);
        apply.setDataId(dataId);
        int result = applyMapper.insert(apply);
        if(result > 0){
            return result > 0;
        }else{
            throw new BusinessException(ErrorCode.OPERATION_ERROR);
        }
    }

    public Boolean deleteApply(String userId, String dataId, ApplyTypeEnum type){
        Apply apply = new Apply();
        apply.setType(type);
        apply.setUserId(userId);
        apply.setDataId(dataId);
        QueryWrapper<Apply> wrapper=new QueryWrapper<>(apply);
        int result = applyMapper.delete(wrapper);
        if(result > 0){
            return result > 0;
        }else{
            throw new BusinessException(ErrorCode.OPERATION_ERROR);
        }
    }

    public Boolean isApply(String userId, String dataId, ApplyTypeEnum type){
        Apply apply = new Apply();
        apply.setType(type);
        apply.setUserId(userId);
        apply.setDataId(dataId);
        QueryWrapper<Apply> wrapper=new QueryWrapper<>(apply);
        Apply result = applyMapper.selectOne(wrapper);
        if(result == null){
            return false;
        }else{
            return true;
        }
    }

    public PageListResponse getApplyList(long current, long pageSize, String userId, ApplyTypeEnum type){
        // 分类查询
        if(type == ApplyTypeEnum.MSYQ){
            Page<ResumeVo> page = applyMapper.getMSYQList(new Page<>(current, pageSize), userId, type);
            PageListResponse result = new PageListResponse();
            result.setList(page.getRecords());
            result.setTotal(page.getTotal());
            return result;
        }else if(type == ApplyTypeEnum.TDJL){
            Page<JobInfoVo> page = applyMapper.getTDJLList(new Page<>(current, pageSize), userId, type);
            PageListResponse result = new PageListResponse();
            result.setList(page.getRecords());
            result.setTotal(page.getTotal());
            return result;
        }else{
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
    }
}
