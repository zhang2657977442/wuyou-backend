package com.example.wuyou.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.wuyou.handler.DateTypeHandler;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 职位信息;
 * @author : One Direction
 * @date : 2022-12-13
 */
@Data
@ApiModel(value = "职位信息",description = "")
@TableName(autoResultMap = true)
public class Position implements Serializable,Cloneable {
    /** 主键 */
    @ApiModelProperty(name = "主键",notes = "")
    @TableId
    private String  id ;
    /** 名称 */
    @ApiModelProperty(name = "名称",notes = "")
    private String name ;
    /** 图标地址 */
    @ApiModelProperty(name = "图标地址",notes = "")
    private String icon ;
    /** 父级id */
    @ApiModelProperty(name = "父级id",notes = "")
    private String pId ;
    /** 启用状态 */
    @TableField(value = "enable_status", fill = FieldFill.INSERT)
    @ApiModelProperty(name = "启用状态",notes = "")
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
