package com.example.wuyou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wuyou.model.entity.Browse;
import com.example.wuyou.model.enums.BrowseTypeEnum;
import com.example.wuyou.model.vo.CompanyInfoVo;
import com.example.wuyou.model.vo.ResumeVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface BrowseMapper extends BaseMapper<Browse>{

    @Select("SELECT c.id,c.name,c.full_name,c.logo,c.nature,c.staff_size,c.introduce,c.address,c.city_id,c.auth_id,c.work_time,c.rest_time,c.work_overtime,c.enable_status,c.create_time,c.update_time,i.name industry_name from browse b, company c,industry i " +
            "where b.user_id = #{user_id} and b.type = #{type} and b.data_id = c.id and c.industry_id = i.id")
    Page<CompanyInfoVo> getLLGWList(Page<CompanyInfoVo> page, @Param("user_id") String userId, @Param("type") BrowseTypeEnum type);

    @Select("SELECT r.id, r.birthday, r.name, r.gender, r.education, r.experience, r.skill, r.job_status, r.salary, r.post_id, r.create_time, u.username, u.mobile, u.avatar user_avatar, p.name post_name from user u,browse b,resume r,position p " +
            "where b.user_id = #{user_id} and b.type = #{type} and b.data_id = r.id and r.post_id = p.id and r.user_id = u.id")
    Page<ResumeVo> getLLJLList(Page<ResumeVo> page, @Param("user_id") String userId,  @Param("type") BrowseTypeEnum type);
}
