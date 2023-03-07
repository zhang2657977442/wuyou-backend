package com.example.wuyou.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.wuyou.handler.DateTypeHandler;
import com.example.wuyou.model.enums.CollectTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 收藏信息;
 * @author : One Direction
 * @date : 2022-12-13
 */
@Data
@ApiModel(value = "收藏信息",description = "")
@TableName(autoResultMap = true)
public class Collect implements Serializable,Cloneable{
    @ApiModelProperty(name = "主键",notes = "")
    private String id ;
    /** 用户ID */
    @ApiModelProperty(name = "用户ID",notes = "")
    private String userId ;
    /** 数据ID */
    @ApiModelProperty(name = "数据ID",notes = "")
    private String dataId ;
    /** 类型 */
    @ApiModelProperty(name = "类型",notes = "")
    private CollectTypeEnum type ;
    /** 创建时间 */
    @TableField(value = "create_time", fill = FieldFill.INSERT, typeHandler = DateTypeHandler.class)
    @ApiModelProperty(name = "创建时间",notes = "")
    private Date createTime ;
}
