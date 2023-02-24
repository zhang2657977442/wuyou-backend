package com.example.wuyou.service.impl;

import com.example.wuyou.common.ErrorCode;
import com.example.wuyou.exception.BusinessException;
import com.example.wuyou.mapper.CollectMapper;
import com.example.wuyou.model.entity.Collect;
import com.example.wuyou.model.enums.CollectTypeEnum;
import com.example.wuyou.service.CollectService;
import com.example.wuyou.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;

    public Boolean addCollect(String userId, String jobId, CollectTypeEnum type){
        Collect collect = new Collect();
        String id = new UuidUtils().getShortUuid();
        collect.setId(id);
        collect.setType(type);
        collect.setUserId(userId);
        collect.setJobId(jobId);
        int result = collectMapper.insert(collect);
        if(result > 0){
            return result > 0;
        }else{
            throw new BusinessException(ErrorCode.OPERATION_ERROR);
        }
    }
}
