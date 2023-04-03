package com.example.wuyou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.model.entity.Collect;
import com.example.wuyou.model.enums.CollectTypeEnum;
import com.example.wuyou.model.vo.CollectVo;
import com.example.wuyou.model.vo.JobInfoVo;
import com.example.wuyou.model.vo.ResumeVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CollectMapper extends BaseMapper<Collect>{
    @Select("SELECT j.id,j.company_id,j.enable_status,j.exp_require,j.min_education,j.salary,j.job_type,j.skill,j.create_time,j.update_time,p.name post_name,c.name company_name,c.nature,c.staff_size,c.address,pp.name post_category,i.name industry_name,u.username user_name,u.avatar user_avatar from collect a, job j,position p,company c,position pp,industry i,user u " +
            "where a.user_id = #{user_id} and a.type = #{type} and a.data_id = j.id and j.post_id = p.id and j.company_id = c.id and p.p_id = pp.id and c.industry_id = i.id and u.company_id = c.id")
    Page<JobInfoVo> getSCGWList(Page<JobInfoVo> page, @Param("user_id") String userId, @Param("type") CollectTypeEnum type);

    @Select("SELECT r.id, r.birthday, r.name, r.gender, r.education, r.experience, r.skill, r.job_status, r.salary, r.post_id, r.create_time, u.username, u.mobile, u.avatar user_avatar, p.name post_name from user u,collect c,resume r,position p " +
            "where c.user_id = #{user_id} and c.type = #{type} and c.data_id = r.id and r.post_id = p.id and r.user_id = u.id")
    Page<ResumeVo> getSCJLList(Page<ResumeVo> page, @Param("user_id") String userId,  @Param("type") CollectTypeEnum type);

    @Select("SELECT c.id, u.username, p.name, c.type, c.create_time from user u, collect c, job j, position p " +
            "where c.type = #{type} and c.data_id = j.id and u.id = c.user_id and j.post_id = p.id")
    Page<CollectVo> getSCGW(Page<CollectVo> page, @Param("type") CollectTypeEnum type);

    @Select("SELECT c.id, u.username, r.name, c.type, c.create_time from user u, collect c, resume r " +
            "where c.type = #{type} and c.data_id = r.id and u.id = c.user_id")
    Page<CollectVo> getSCJL(Page<CollectVo> page, @Param("type") CollectTypeEnum type);


}
