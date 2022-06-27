package com.agoni.dgy.config;

import com.agoni.security.utils.UserUtil;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


/**
 * 自动填充
 * @author dgy
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 创建自动填充字段
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createBy", UserUtil.getUserName(), metaObject);
        this.setFieldValByName("createByName", UserUtil.getName(), metaObject);
        this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
    }

    /**
     * 更新自动填充字段
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateBy", UserUtil.getUserName(), metaObject);
        this.setFieldValByName("updateByName", UserUtil.getName(), metaObject);
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }


    /**
     * 新版
     * 乐观锁插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        // 乐观锁插件
        mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        // 分页插件
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
        return mybatisPlusInterceptor;
    }


}
