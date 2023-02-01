package com.example.wuyou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.model.entity.Company;
import com.example.wuyou.model.vo.CompanyInfoVo;
import org.apache.ibatis.annotations.Select;

public interface CompanyMapper extends BaseMapper<Company> {
    // 联表查询
    @Select("SELECT c.id,c.name,c.full_name,c.logo,c.nature,c.staff_size,c.introduce,c.address,c.city_id,c.auth_id,c.work_time,c.rest_time,c.work_overtime,c.enable_status,c.create_time,c.update_time,i.name industry_name from company c,industry i " +
            "where c.industry_id = i.id")
    Page<CompanyInfoVo> selectCompanyPage(Page<CompanyInfoVo> page);
}
