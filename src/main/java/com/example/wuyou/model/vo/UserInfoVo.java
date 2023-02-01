package com.example.wuyou.model.vo;

import java.io.Serializable;
import java.util.Date;

import com.example.wuyou.model.enums.UserRoleEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "用户信息VO",description = "")
public class UserInfoVo implements Serializable {
    @ApiModelProperty(name = "主键",notes = "")
    private String  id ;
    /** 用户名 */
    @ApiModelProperty(name = "用户名",notes = "")
    private String username ;
    /** 手机号码 */
    @ApiModelProperty(name = "手机号码",notes = "")
    private String mobile ;
    /** 头像地址 */
    @ApiModelProperty(name = "头像地址",notes = "")
    private String avatar ;
    /** 用户角色 */
    @ApiModelProperty(name = "用户角色",notes = "")
    private UserRoleEnum role ;
    /** 公司id */
    @ApiModelProperty(name = "公司id",notes = "")
    private String companyId ;
    /** 认证id */
    @ApiModelProperty(name = "认证id",notes = "")
    private String authId ;
    /** 注册时间 */
    @ApiModelProperty(name = "注册时间",notes = "")
    private Date registerDate ;
}
