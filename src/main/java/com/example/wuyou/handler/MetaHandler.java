package com.example.wuyou.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
import com.example.wuyou.model.enums.UserRoleEnum;

@Component
public class MetaHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) { // 插入操作时，添加默认数据
        this.fillStrategy(metaObject,"role", UserRoleEnum.DEFAULT);
        this.fillStrategy(metaObject,"enableStatus", true);
        this.fillStrategy(metaObject,"registerDate", new Date());
        this.fillStrategy(metaObject,"createTime", new Date());

    }

    @Override
    public void updateFill(MetaObject metaObject) {// 更新操作时 添加默认数据
        // TODO Auto-generated method stub

    }

}
