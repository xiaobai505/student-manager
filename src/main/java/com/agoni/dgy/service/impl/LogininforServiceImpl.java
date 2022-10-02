package com.agoni.dgy.service.impl;

import com.agoni.dgy.mapper.LogininforMapper;
import com.agoni.dgy.model.po.Logininfor;
import com.agoni.dgy.service.LogininforService;
import com.agoni.system.utils.httpUitl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
* @author Admin
* @description 针对表【tb_logininfor(系统访问记录)】的数据库操作Service实现
* @createDate 2022-08-31 16:29:20
*/
@Service
@Slf4j
public class LogininforServiceImpl extends ServiceImpl<LogininforMapper, Logininfor> implements LogininforService {
    
    /**
     * 异步插入日志，async ，不能保证事物
     *
     * @param username
     * @param status
     * @param message
     */
    @Override
    public void asyncLogininfor(String username, String status, String message, HttpServletRequest request) {
        // 插入数据
        Logininfor logininfor = httpUitl.getLogininfor(request);
        logininfor.setUserName(username);
        logininfor.setStatus(status);
        logininfor.setMsg(message);
        logininfor.setLoginTime(LocalDateTime.now());
        save(logininfor);
    }
}




