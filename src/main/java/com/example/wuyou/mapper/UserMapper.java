package com.example.wuyou.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.wuyou.model.entity.User;
@Mapper
public interface UserMapper {
    /**
     * 通过ID查询单条数据
     * @return 实例对象
     */
    User getInfo();
}
