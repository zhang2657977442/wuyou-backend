package com.example.wuyou.service.impl;

import com.example.wuyou.common.ErrorCode;
import com.example.wuyou.exception.BusinessException;
import com.example.wuyou.mapper.BrowseMapper;
import com.example.wuyou.model.entity.Browse;
import com.example.wuyou.model.enums.BrowseTypeEnum;
import com.example.wuyou.service.BrowseService;
import com.example.wuyou.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrowseServiceImpl implements BrowseService {
    @Autowired
    private BrowseMapper browseMapper;

    public Boolean addBrowse(String userId, String jobId, BrowseTypeEnum type){
        Browse browse = new Browse();
        String id = new UuidUtils().getShortUuid();
        browse.setId(id);
        browse.setType(type);
        browse.setUserId(userId);
        browse.setJobId(jobId);
        int result = browseMapper.insert(browse);
        if(result > 0){
            return result > 0;
        }else{
            throw new BusinessException(ErrorCode.OPERATION_ERROR);
        }
    }
}
