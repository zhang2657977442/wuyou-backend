package com.example.wuyou.model.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.wuyou.model.enums.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "工作信息VO",description = "")
@TableName(autoResultMap = true)
public class JobInfoVo implements Serializable{
    /** 主键 */
    @ApiModelProperty(name = "主键",notes = "")
    private String id ;
    /** 生效状态 */
    @TableField(value = "enable_status", fill = FieldFill.INSERT)
    @ApiModelProperty(name = "生效状态",notes = "")
    private Boolean enableStatus ;
    /** 经验要求 */
    @ApiModelProperty(name = "经验要求",notes = "")
    private ExperienceEnum expRequire ;
    /** 最低学历 */
    @ApiModelProperty(name = "最低学历",notes = "")
    private EducationEnum minEducation ;
    /** 薪资范围 */
    @ApiModelProperty(name = "薪资范围",notes = "")
    private SalaryEnum salary ;
    /** 工作类型 */
    @ApiModelProperty(name = "工作类型",notes = "")
    private JobTypeEnum jobType ;
    /** 技能要求 */
    @ApiModelProperty(name = "技能要求",notes = "")
    private String skill ;
    /** 创建时间 */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(name = "创建时间",notes = "")
    private Date createTime ;
    /** 更新时间 */
    @TableField(value = "update_time", fill = FieldFill.INSERT)
    @ApiModelProperty(name = "更新时间",notes = "")
    private Date updateTime ;
    /** 公司名称 */
    @ApiModelProperty(name = "公司名称",notes = "")
    private String companyName ;
    /** 公司性质 */
    @ApiModelProperty(name = "公司性质",notes = "")
    private CompanyNatureEnum nature ;
    /** 公司规模 */
    @ApiModelProperty(name = "公司规模",notes = "")
    private String staffSize ;
    /** 地址详情 */
    @ApiModelProperty(name = "地址详情",notes = "")
    private String address ;
    /** 职位名称 */
    @ApiModelProperty(name = "职位名称",notes = "")
    private String postName ;
    /** 职位类别 */
    @ApiModelProperty(name = "职位类别",notes = "")
    private String postCategory ;
    /** 行业名称 */
    @ApiModelProperty(name = "行业名称",notes = "")
    private String industryName ;
    /** 用户名称 */
    @ApiModelProperty(name = "用户名称",notes = "")
    private String userName ;
    /** 用户头像 */
    @ApiModelProperty(name = "用户头像",notes = "")
    private String userAvatar ;
}
