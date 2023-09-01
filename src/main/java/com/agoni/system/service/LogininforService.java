package com.agoni.system.service;

import com.agoni.core.exception.enums.httpEnum;
import com.agoni.system.model.po.Logininfor;
import com.agoni.system.model.query.LogininforPageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 针对表【sys_logininfor(系统访问记录)】的数据库操作Service
 *
 * @author Admin
 * @since  2022-08-31 16:29:20
 */
public interface LogininforService extends IService<Logininfor> {

    /**
     * 异步插入日志，async ，不能保证事物
     *
     * @param username 用户名
     * @param e Enum对象
     */
    void asyncLogininfor(String username, httpEnum e);

    /**
     * 分页查询
     *
     * @param query 请求对象
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.agoni.system.model.po.Logininfor>
     * @author t-guoyu.dong@pcitc.com
     * @date 2023-07-10
     */
    Page<Logininfor> selectPage(LogininforPageQuery query);
}
