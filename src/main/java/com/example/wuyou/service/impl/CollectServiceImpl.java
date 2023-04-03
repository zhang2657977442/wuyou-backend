package com.example.wuyou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.common.ErrorCode;
import com.example.wuyou.exception.BusinessException;
import com.example.wuyou.mapper.CollectMapper;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Collect;
import com.example.wuyou.model.enums.CollectTypeEnum;
import com.example.wuyou.model.vo.CollectVo;
import com.example.wuyou.model.vo.JobInfoVo;
import com.example.wuyou.model.vo.ResumeVo;
import com.example.wuyou.service.CollectService;
import com.example.wuyou.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;
    // 增加收藏信息
    public Boolean addCollect(String userId, String dataId, CollectTypeEnum type){
        // 创建一个Collect实体类
        Collect collect = new Collect();
        // 生成uuid
        String id = new UuidUtils().getShortUuid();
        // 设置收藏ID
        collect.setId(id);
        // 设置收藏类型
        collect.setType(type);
        // 设置收藏用户ID
        collect.setUserId(userId);
        // 设置收藏数据ID
        collect.setDataId(dataId);
        // 执行插入语句，返回插入成功个数
        int result = collectMapper.insert(collect);
        if(result > 0){
            return result > 0;
        }
        // 否则提示操作失败
        else{
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


    // 判断是否已收藏
    public Boolean isCollect(String userId, String dataId, CollectTypeEnum type){
        // 创建一个Collect实体类
        Collect collect = new Collect();
        // 设置收藏类型
        collect.setType(type);
        // 设置收藏用户ID
        collect.setUserId(userId);
        // 设置收藏数据ID
        collect.setDataId(dataId);
        // 创建条件构造器
        QueryWrapper<Collect> wrapper=new QueryWrapper<>(collect);
        // 查询数据库中是否存在该记录
        Collect result = collectMapper.selectOne(wrapper);
        // 存在返回true,否则返回false
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
            Page<CollectVo> cPage = collectMapper.getSCGW(new Page<>(current, pageSize / 2), CollectTypeEnum.SCGW);
            Page<CollectVo> rPage = collectMapper.getSCJL(new Page<>(current, pageSize / 2), CollectTypeEnum.SCJL);
            PageListResponse result = new PageListResponse();
            List<CollectVo> list = new ArrayList<>();
            list.addAll(cPage.getRecords());
            list.addAll(rPage.getRecords());
            result.setList(list);
            result.setTotal(cPage.getTotal() + rPage.getTotal());
            return result;
        }
    }


    // 删除浏览记录
    public Boolean delete(String id){
        int count = collectMapper.deleteById(id);
        return count > 0;
    }


}
