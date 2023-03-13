package com.example.wuyou.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.model.entity.Job;
import com.example.wuyou.model.vo.JobInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface JobMapper extends BaseMapper<Job> {
    // 联表查询
    @InterceptorIgnore(tenantLine = "true")
    @Select("SELECT j.id,j.company_id,j.enable_status,j.exp_require,j.min_education,j.salary,j.job_type,j.skill,j.create_time,j.update_time,p.name post_name,c.name company_name,c.nature,c.staff_size,c.address,pp.name post_category,i.name industry_name,u.id user_id,u.username,u.mobile,u.avatar user_avatar from job j,position p,company c,position pp,industry i,user u " +
            "where j.post_id = p.id and j.company_id = c.id and p.p_id = pp.id and c.industry_id = i.id and u.company_id = c.id and if (#{job_name} != '', p.name like concat(concat('%',#{job_name}),'%'), 1=1)")
    Page<JobInfoVo> getJobList(Page<JobInfoVo> page, @Param("job_name") String jobName);


}
