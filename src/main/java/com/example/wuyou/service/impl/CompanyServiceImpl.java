package com.example.wuyou.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.common.ErrorCode;
import com.example.wuyou.config.JwtConfig;
import com.example.wuyou.exception.BusinessException;
import com.example.wuyou.mapper.CompanyMapper;
import com.example.wuyou.mapper.UserMapper;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Company;
import com.example.wuyou.model.entity.User;
import com.example.wuyou.model.vo.CompanyInfoVo;
import com.example.wuyou.model.vo.JobInfoVo;
import com.example.wuyou.service.CompanyService;
import com.example.wuyou.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private UserMapper userMapper;

    public PageListResponse getCompanyList(long current, long pageSize){
        // 分页查询
        Page<CompanyInfoVo> page = companyMapper.getCompanyList(new Page<>(current, pageSize));
        PageListResponse result = new PageListResponse();
        result.setList(page.getRecords());
        result.setTotal(page.getTotal());
        return result;
    }

    public PageListResponse getCompanyJob(String id, long current, long pageSize){
        // 分页查询
        Page<JobInfoVo> page = companyMapper.getCompanyJob(new Page<>(current, pageSize), id);
        PageListResponse result = new PageListResponse();
        result.setList(page.getRecords());
        result.setTotal(page.getTotal());
        return result;
    }

    public CompanyInfoVo getCompanyInfo(String id){
        // 分页查询
        CompanyInfoVo result = companyMapper.getCompanyInfo(id);
        if(result == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "暂无数据");
        }
        return result;
    }

    public Boolean updateCompanyInfo(Company params){
        int count = companyMapper.updateById(params);
        return count > 0;
    }

    public Boolean addCompany(Company params,String token){
        // 生成uuid
        String id = new UuidUtils().getShortUuid();
        params.setId(id);
        int count = companyMapper.insert(params);

        // 更新用户信息中的公司ID
        String UserId = JwtConfig.getTokenInfo(token).getClaim("id").asString();
        User user = userMapper.selectById(UserId);

        // 用户不存在
        if (user == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户不存在");
        }
        user.setCompanyId(id);
        int total = userMapper.updateById(user);
        return count > 0 && total > 0;
    }
}
