package com.example.wuyou.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * 福利信息;
 * @author : One Direction
 * @date : 2022-11-22
 */
@ApiModel(value = "福利模型",description = "")
public class BasicWelfare implements Serializable,Cloneable{
    /** 主键 */
    @ApiModelProperty(name = "主键",notes = "")
    private String id ;
    /** 名称 */
    @ApiModelProperty(name = "名称",notes = "")
    private String name ;
    /** 图标地址 */
    @ApiModelProperty(name = "图标地址",notes = "")
    private String icon ;
    /** 启用状态 */
    @ApiModelProperty(name = "启用状态",notes = "")
    private Boolean enableStatus ;
    /** 创建时间 */
    @ApiModelProperty(name = "创建时间",notes = "")
    private Double createTime ;
    /** 更新时间 */
    @ApiModelProperty(name = "更新时间",notes = "")
    private Double updateTime ;

    /** 主键 */
    public String getId(){
        return this.id;
    }
    /** 主键 */
    public void setId(String id){
        this.id=id;
    }
    /** 名称 */
    public String getName(){
        return this.name;
    }
    /** 名称 */
    public void setName(String name){
        this.name=name;
    }
    /** 图标地址 */
    public String getIcon(){
        return this.icon;
    }
    /** 图标地址 */
    public void setIcon(String icon){
        this.icon=icon;
    }
    /** 启用状态 */
    public Boolean getEnableStatus(){
        return this.enableStatus;
    }
    /** 启用状态 */
    public void setEnableStatus(Boolean enableStatus){
        this.enableStatus=enableStatus;
    }
    /** 创建时间 */
    public Double getCreateTime(){
        return this.createTime;
    }
    /** 创建时间 */
    public void setCreateTime(Double createTime){
        this.createTime=createTime;
    }
    /** 更新时间 */
    public Double getUpdateTime(){
        return this.updateTime;
    }
    /** 更新时间 */
    public void setUpdateTime(Double updateTime){
        this.updateTime=updateTime;
    }
}
