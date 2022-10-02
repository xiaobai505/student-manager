package com.agoni.dgy.service;

import com.agoni.dgy.model.po.Logininfor;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
* @author Admin
* @description 针对表【tb_logininfor(系统访问记录)】的数据库操作Service
* @createDate 2022-08-31 16:29:20
*/
public interface LogininforService extends IService<Logininfor> {
    
    /**
     * 异步插入日志，async ，不能保证事物
     * @param username
     * @param status
     * @param message
     */
    void asyncLogininfor(String username, String status, String message, HttpServletRequest request);
}
