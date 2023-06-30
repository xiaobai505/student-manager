package com.agoni.system.service;

import com.agoni.system.model.po.Logininfor;
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
     * @param username 用户名
     * @param status 状态
     * @param message 消息
     */
    void asyncLogininfor(String username, String status, String message);
}
