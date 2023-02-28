package com.example.wuyou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.model.entity.Apply;
import com.example.wuyou.model.enums.ApplyTypeEnum;
import com.example.wuyou.model.vo.JobInfoVo;
import com.example.wuyou.model.vo.ResumeVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ApplyMapper extends BaseMapper<Apply>{

    @Select("SELECT j.id,j.company_id,j.enable_status,j.exp_require,j.min_education,j.salary,j.job_type,j.skill,j.create_time,j.update_time,p.name post_name,c.name company_name,c.nature,c.staff_size,c.address,pp.name post_category,i.name industry_name,u.username user_name,u.avatar user_avatar from apply a, job j,position p,company c,position pp,industry i,user u " +
            "where a.user_id = #{user_id} and a.type = #{type} and a.job_id = j.id and j.post_id = p.id and j.company_id = c.id and p.p_id = pp.id and c.industry_id = i.id and u.company_id = c.id")
    Page<JobInfoVo> getTDJLList(Page<JobInfoVo> page, @Param("user_id") String userId, @Param("type") ApplyTypeEnum type);

    @Select("SELECT r.id, r.birthday, r.name, r.gender, r.education, r.experience, r.skill, r.job_status, r.salary, r.post_id, r.create_time, u.username, u.mobile, u.avatar user_avatar, p.name post_name from user u,company c,job j,apply a,resume r,position p " +
            "where u.id = #{user_id} and u.company_id = c.id and c.id = j.company_id and j.id = a.job_id and a.type = #{type} and a.user_id = r.user_id and r.post_id = p.id")
    Page<ResumeVo> getMSYQList(Page<ResumeVo> page, @Param("user_id") String userId, @Param("type") ApplyTypeEnum type);
}
