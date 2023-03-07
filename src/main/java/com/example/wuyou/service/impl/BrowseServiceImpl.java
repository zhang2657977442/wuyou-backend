package com.example.wuyou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.common.ErrorCode;
import com.example.wuyou.exception.BusinessException;
import com.example.wuyou.mapper.BrowseMapper;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Browse;
import com.example.wuyou.model.enums.BrowseTypeEnum;
import com.example.wuyou.model.vo.CompanyInfoVo;
import com.example.wuyou.model.vo.ResumeVo;
import com.example.wuyou.service.BrowseService;
import com.example.wuyou.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrowseServiceImpl implements BrowseService {
    @Autowired
    private BrowseMapper browseMapper;

    public Boolean addBrowse(String userId, String dataId, BrowseTypeEnum type){
        Browse browse = new Browse();
        browse.setType(type);
        browse.setUserId(userId);
        browse.setDataId(dataId);
        QueryWrapper<Browse> wrapper=new QueryWrapper<>(browse);
        Browse result = browseMapper.selectOne(wrapper);
        if(result == null) {
            String id = new UuidUtils().getShortUuid();
            browse.setId(id);
            int count = browseMapper.insert(browse);
            if(count > 0){
                return count > 0;
            }else{
                throw new BusinessException(ErrorCode.OPERATION_ERROR);
            }
        }
       else{
             return true;
       }
    }

    public PageListResponse getBrowseList(long current, long pageSize, String userId, BrowseTypeEnum type){
        // 分类查询
        if(type == BrowseTypeEnum.LLGW){
            Page<CompanyInfoVo> page = browseMapper.getLLGWList(new Page<>(current, pageSize), userId, type);
            PageListResponse result = new PageListResponse();
            result.setList(page.getRecords());
            result.setTotal(page.getTotal());
            return result;
        }else if(type == BrowseTypeEnum.LLJL){
            Page<ResumeVo> page = browseMapper.getLLJLList(new Page<>(current, pageSize), userId, type);
            PageListResponse result = new PageListResponse();
            result.setList(page.getRecords());
            result.setTotal(page.getTotal());
            return result;
        }else{
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
    }
}
