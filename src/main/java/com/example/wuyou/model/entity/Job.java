package com.example.wuyou.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.wuyou.handler.DateTypeHandler;
import com.example.wuyou.model.enums.EducationEnum;
import com.example.wuyou.model.enums.ExperienceEnum;
import com.example.wuyou.model.enums.JobTypeEnum;
import com.example.wuyou.model.enums.SalaryEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 公司职位信息;
 * @author : One Direction
 * @date : 2022-12-13
 */
@Data
@ApiModel(value = "公司职位信息",description = "")
@TableName(autoResultMap = true)
public class Job implements Serializable,Cloneable{
    /** 主键 */
    @ApiModelProperty(name = "主键",notes = "")
    private String id ;
    /** 公司id */
    @ApiModelProperty(name = "公司id",notes = "")
    private String companyId ;
    /** 职位id */
    @ApiModelProperty(name = "职位id",notes = "")
    private String postId ;
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
    @TableField(value = "create_time", fill = FieldFill.INSERT, typeHandler = DateTypeHandler.class)
    @ApiModelProperty(name = "创建时间",notes = "")
    private Date createTime ;
    /** 更新时间 */
    @TableField(value = "update_time", fill = FieldFill.INSERT, typeHandler = DateTypeHandler.class)
    @ApiModelProperty(name = "更新时间",notes = "")
    private Date updateTime ;
}
