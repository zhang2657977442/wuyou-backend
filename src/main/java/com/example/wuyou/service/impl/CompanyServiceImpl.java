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
    // 获取公司信息
    public CompanyInfoVo getCompanyInfo(String id){
        // 执行查询公司信息Sql语句
        CompanyInfoVo result = companyMapper.getCompanyInfo(id);
        // 如果不存在返回暂无数据
        if(result == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "暂无数据");
        }
        // 如果存在返回查询结果
        return result;
    }

    // 招聘者新增公司信息
    public Boolean addCompany(Company params,String token){
        // 生成uuid
        String id = new UuidUtils().getShortUuid();
        // 设置公司信息ID
        params.setId(id);
        // 执行插入语句，返回插入成功个数
        int count = companyMapper.insert(params);
        // 更新招聘者信息中的公司ID
        String UserId = JwtConfig.getTokenInfo(token).getClaim("id").asString();
        User user = userMapper.selectById(UserId);
        // 如果聘者不存在，提示用户不存在
        if (user == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户不存在");
        }
        // 如果用户存在，更新招聘者的公司ID
        user.setCompanyId(id);
        int total = userMapper.updateById(user);
        // 插入和更新同时完成视为操作成功
        return count > 0 && total > 0;
    }

    // 删除公司信息
    public Boolean deleteCompany(String id){
        int count = companyMapper.deleteById(id);
        return count > 0;
    }

    // 管理员新增公司信息
    public Boolean addCompanyInfo (Company params){
        // 生成uuid
        String id = new UuidUtils().getShortUuid();
        // 设置公司信息ID
        params.setId(id);
        int count = companyMapper.insert(params);
        return count > 0;
    }

    // 更新公司信息
    public Boolean updateCompanyInfo(Company params){
        int count = companyMapper.updateById(params);
        return count > 0;
    }

}
