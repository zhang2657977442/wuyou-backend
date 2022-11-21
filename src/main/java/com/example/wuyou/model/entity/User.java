package com.example.wuyou.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * 用户信息;
 * @author : http://www.chiner.pro
 * @date : 2022-11-18
 */
@ApiModel("用户模型")
public class User implements Serializable,Cloneable{
    @ApiModelProperty(name = "主键",notes = "")
    private String  id ;
    /** 用户名 */
    @ApiModelProperty(name = "用户名",notes = "")
    private String username ;
    /** 密码 */
    @ApiModelProperty(name = "密码",notes = "")
    private String password ;
    /** 手机号码 */
    @ApiModelProperty(name = "手机号码",notes = "")
    private String mobile ;
    /** 头像地址 */
    @ApiModelProperty(name = "头像地址",notes = "")
    private String avatar ;
    /** 用户角色 */
    @ApiModelProperty(name = "用户角色",notes = "")
    private int role ;
    /** 公司id */
    @ApiModelProperty(name = "公司id",notes = "")
    private String companyId ;
    /** 账号状态 */
    @ApiModelProperty(name = "账号状态",notes = "")
    private Boolean enableStatus ;
    /** 认证id */
    @ApiModelProperty(name = "认证id",notes = "")
    private String authId ;
    /** 注册时间 */
    @ApiModelProperty(name = "注册时间",notes = "")
    private Double registerDate ;


    public String getId(){
        return this.id;
    }
    /** 主键 */
    public void setId(String id){
        this.id=id;
    }
    /** 用户名 */
    public String getUsername(){
        return this.username;
    }
    /** 用户名 */
    public void setUsername(String username){
        this.username=username;
    }
    /** 密码 */
    public String getPassword(){
        return this.password;
    }
    /** 密码 */
    public void setPassword(String password){
        this.password=password;
    }
    /** 手机号码 */
    public String getMobile(){
        return this.mobile;
    }
    /** 手机号码 */
    public void setMobile(String mobile){
        this.mobile=mobile;
    }
    /** 头像地址 */
    public String getAvatar(){
        return this.avatar;
    }
    /** 头像地址 */
    public void setAvatar(String avatar){
        this.avatar=avatar;
    }
    /** 用户角色 */
    public Integer getRole(){
        return this.role;
    }
    /** 用户角色 */
    public void setRole(Integer role){
        this.role=role;
    }
    /** 公司id */
    public String getCompanyId(){
        return this.companyId;
    }
    /** 公司id */
    public void setCompanyId(String companyId){
        this.companyId=companyId;
    }
    /** 账号状态 */
    public Boolean getEnableStatus(){
        return this.enableStatus;
    }
    /** 账号状态 */
    public void setEnableStatus(Boolean enableStatus){
        this.enableStatus=enableStatus;
    }
    /** 认证id */
    public String getAuthId(){
        return this.authId;
    }
    /** 认证id */
    public void setAuthId(String authId){
        this.authId=authId;
    }
    /** 注册时间 */
    public Double getRegisterDate(){
        return this.registerDate;
    }
    /** 注册时间 */
    public void setRegisterDate(Double registerDate){
        this.registerDate=registerDate;
    }
}
