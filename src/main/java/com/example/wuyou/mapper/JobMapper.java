package com.example.wuyou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.model.entity.Job;
import com.example.wuyou.model.vo.JobInfoVo;
import org.apache.ibatis.annotations.Select;

public interface JobMapper extends BaseMapper<Job> {
    // 联表查询
    @Select("SELECT j.id,j.enable_status,j.exp_require,j.min_education,j.salary,j.job_type,j.skill,j.create_time,j.update_time,p.name post_name,c.name company_name,c.nature,c.staff_size,c.address,pp.name post_category,i.name industry_name,u.username user_name,u.avatar user_avatar from job j,position p,company c,position pp,industry i,user u " +
            "where j.post_id = p.id and j.company_id = c.id and p.p_id = pp.id and c.industry_id = i.id and u.company_id = c.id")
    Page<JobInfoVo> selectJobPage(Page<JobInfoVo> page);
}
