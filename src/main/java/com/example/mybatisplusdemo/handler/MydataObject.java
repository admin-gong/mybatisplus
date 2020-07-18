package com.example.mybatisplusdemo.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;



import lombok.extern.slf4j.XSlf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class MydataObject  implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        //log.info("start insert fill ....");
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);



    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
