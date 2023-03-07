package com.example.wuyou.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.wuyou.handler.DateTypeHandler;
import com.example.wuyou.model.enums.CompanyNatureEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 公司信息;
 * @author : One Direction
 * @date : 2022-12-13
 */
@Data
@ApiModel(value = "公司信息",description = "")
@TableName(autoResultMap = true)
public class Company implements Serializable,Cloneable{
    /** 主键 */
    @ApiModelProperty(name = "主键",notes = "")
    private String id ;
    /** 简称 */
    @ApiModelProperty(name = "简称",notes = "")
    private String name ;
    /** 全称 */
    @ApiModelProperty(name = "全称",notes = "")
    private String fullName ;
    /** logo地址 */
    @ApiModelProperty(name = "logo地址",notes = "")
    private String logo ;
    /** 行业id */
    @ApiModelProperty(name = "行业id",notes = "")
    private String industryId ;
    /** 公司性质 */
    @ApiModelProperty(name = "公司性质",notes = "")
    private CompanyNatureEnum nature ;
    /** 公司规模 */
    @ApiModelProperty(name = "公司规模",notes = "")
    private String staffSize ;
    /** 公司简介 */
    @ApiModelProperty(name = "公司简介",notes = "")
    private String introduce ;
    /** 地址详情 */
    @ApiModelProperty(name = "地址详情",notes = "")
    private String address ;
    /** 城市id */
    @ApiModelProperty(name = "城市id",notes = "")
    private String cityId ;
    /** 认证id */
    @ApiModelProperty(name = "认证id",notes = "")
    private String authId ;
    /** 工作时间 */
    @ApiModelProperty(name = "工作时间",notes = "")
    private String workTime ;
    /** 休息时间 */
    @ApiModelProperty(name = "休息时间",notes = "")
    private String restTime ;
    /** 加班情况 */
    @ApiModelProperty(name = "加班情况",notes = "")
    private String workOvertime ;
    /** 生效状态 */
    @ApiModelProperty(name = "生效状态",notes = "")
    private Boolean enableStatus ;
    /** 创建时间 */
    @TableField(value = "create_time", fill = FieldFill.INSERT, typeHandler = DateTypeHandler.class)
    @ApiModelProperty(name = "创建时间",notes = "")
    private Date createTime ;
    /** 更新时间 */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE, typeHandler = DateTypeHandler.class)
    @ApiModelProperty(name = "更新时间",notes = "")
    private Date updateTime ;
}
