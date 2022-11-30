package com.example.wuyou.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;


/**
 * 城市信息;
 * @author : One Direction
 * @date : 2022-11-22
 */
@ApiModel(value = "城市模型",description = "")
public class BasicCity implements Serializable,Cloneable{
    /** 主键 */
    @ApiModelProperty(name = "主键",notes = "")
    private String id ;
    /** 名称 */
    @ApiModelProperty(name = "名称",notes = "")
    private String name ;
    /** 父级id */
    @ApiModelProperty(name = "父级id",notes = "")
    private String pId ;

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
    /** 父级id */
    public String getPId(){
        return this.pId;
    }
    /** 父级id */
    public void setPId(String pId){
        this.pId=pId;
    }
}
