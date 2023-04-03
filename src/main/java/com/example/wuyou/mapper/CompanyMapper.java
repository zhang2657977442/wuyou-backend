package com.example.wuyou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.model.entity.Company;
import com.example.wuyou.model.vo.CompanyInfoVo;
import com.example.wuyou.model.vo.JobInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CompanyMapper extends BaseMapper<Company> {
    // 联表查询
    @Select("SELECT c.id,c.name,c.full_name,c.logo,c.nature,c.staff_size,c.introduce,c.address,c.auth_id,c.work_time,c.rest_time,c.work_overtime,c.enable_status,c.create_time,c.update_time,i.name industry_name, c.industry_id from company c,industry i " +
            "where c.industry_id = i.id")
    Page<CompanyInfoVo> getCompanyList(Page<CompanyInfoVo> page);

    @Select("SELECT j.id,j.company_id,j.enable_status,j.exp_require,j.min_education,j.salary,j.job_type,j.skill,j.create_time,j.update_time,p.name post_name,c.name company_name,c.nature,c.staff_size,c.address,pp.name post_category,i.name industry_name,u.id user_id,u.username,u.mobile,u.avatar user_avatar from job j,position p,company c,position pp,industry i,user u " +
            "where j.company_id = #{id} and j.post_id = p.id and j.company_id = c.id and p.p_id = pp.id and c.industry_id = i.id and u.company_id = c.id")
    Page<JobInfoVo> getCompanyJob(Page<JobInfoVo> page, @Param("id") String id);

    @Select("SELECT c.id,c.name,c.full_name,c.logo,c.nature,c.staff_size,c.introduce,c.address,c.auth_id,c.work_time,c.rest_time,c.work_overtime,c.enable_status,c.create_time,c.update_time,i.name industry_name from company c,industry i " +
            "where c.id = #{id} and c.industry_id = i.id")
    CompanyInfoVo getCompanyInfo(@Param("id") String id);


}
