package com.example.wuyou.model.vo;

import com.example.wuyou.model.enums.BrowseTypeEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BrowseVo implements Serializable {
    /** id */
    private String id;

    /** 用户名 */
    private String username;

    /** 数据名称(可能为公司名字或简历名字) */
    private String name;

    /** 类型 */
    private BrowseTypeEnum type ;

    /** 创建时间 */
    private Date createTime ;
}
