package com.example.wuyou.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.mapper.WelfareMapper;
import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Welfare;
import com.example.wuyou.service.WelfareService;
import com.example.wuyou.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WelfareServiceImpl implements WelfareService {
    @Autowired
    private WelfareMapper welfareMapper;


    public PageListResponse getWelfareList(long current, long pageSize){
        // 分页查询
        Page<Welfare> page = welfareMapper.selectPage(new Page<>(current, pageSize), null);
        PageListResponse result = new PageListResponse();
        result.setList(page.getRecords());
        result.setTotal(page.getTotal());
        return result;
    }
    // 删除福利
    public Boolean deleteWelfare(String id){
        int count = welfareMapper.deleteById(id);
        return count > 0;
    }

    // 新增福利
    public Boolean addWelfare(Welfare params){
        // 生成uuid
        String id = new UuidUtils().getShortUuid();
        // 设置用户ID
        params.setId(id);
        // 执行插入语句，返回插入成功个数
        int count = welfareMapper.insert(params);
        return count > 0;
    }

    // 更新福利
    public Boolean updateWelfare(Welfare params){
        int count = welfareMapper.updateById(params);
        return count > 0;
    }
}
