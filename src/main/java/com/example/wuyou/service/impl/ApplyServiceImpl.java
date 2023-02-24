package com.example.wuyou.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.common.ErrorCode;
import com.example.wuyou.exception.BusinessException;
import com.example.wuyou.mapper.ApplyMapper;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Apply;
import com.example.wuyou.model.enums.ApplyTypeEnum;
import com.example.wuyou.service.ApplyService;
import com.example.wuyou.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    private ApplyMapper applyMapper;

    public Boolean addApply(String userId, String jobId, ApplyTypeEnum type){
        Apply apply = new Apply();
        String id = new UuidUtils().getShortUuid();
        apply.setId(id);
        apply.setType(type);
        apply.setUserId(userId);
        apply.setJobId(jobId);
        int result = applyMapper.insert(apply);
        if(result > 0){
            return result > 0;
        }else{
            throw new BusinessException(ErrorCode.OPERATION_ERROR);
        }
    }
}
