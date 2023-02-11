package com.example.wuyou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.model.entity.Resume;
import com.example.wuyou.model.vo.ResumeVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ResumeMapper extends BaseMapper<Resume>{

    @Select("SELECT r.id, r.birthday, r.name, r.gender, r.education, r.experience, r.skill, r.job_status, r.salary, r.post_id, r.create_time, u.username, u.mobile, u.avatar user_avatar, p.name post_name from resume r, user u, position p " +
            "where r.user_id = u.id and r.post_id = p.id and if (#{keyword} != '', r.skill like concat(concat('%',#{keyword}),'%'), 1=1)")
    Page<ResumeVo> getResumeList(Page<ResumeVo> page, @Param("keyword") String keyword);

    @Select("SELECT r.id, r.birthday, r.name, r.gender, r.education, r.experience, r.skill, r.job_status, r.salary, r.post_id, r.create_time, u.username, u.mobile, u.avatar user_avatar, p.name post_name from resume r, user u, position p " +
            "where r.id = #{id} and r.post_id = p.id and r.user_id = u.id")
    ResumeVo getResumeInfo(@Param("id") String id);
}
