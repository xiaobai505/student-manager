package com.agoni.system.service.impl;

import com.agoni.core.exception.ResponseCodeEnum;
import com.agoni.core.omp.OmpDbUtil;
import com.agoni.system.mapper.LogininforMapper;
import com.agoni.system.model.po.Logininfor;
import com.agoni.system.model.query.LogininforQuery;
import com.agoni.system.service.LogininforService;
import com.agoni.system.utils.httpUitl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
* @author Admin
* &#064;description  针对表【sys_logininfor(系统访问记录)】的数据库操作Service实现
* &#064;createDate  2022-08-31 16:29:20
 */
@Service
@Slf4j
public class LogininforServiceImpl
        extends ServiceImpl<LogininforMapper, Logininfor>
        implements LogininforService {

    @Override
    public void asyncLogininfor(String username, ResponseCodeEnum e) {
        // 插入数据
        Logininfor logininfor = httpUitl.getLogininfor();
        logininfor.setUserName(username);
        logininfor.setStatus(e.getCode());
        logininfor.setMsg(e.getMsg());
        logininfor.setLoginTime(LocalDateTime.now());
        save(logininfor);
    }

    @Override
    public Page<Logininfor> selectPage(LogininforQuery query) {
        QueryWrapper<Logininfor> queryWrapper = new QueryWrapper<>();
        fillQueryWrapper(query, queryWrapper);
        Page<Logininfor> page = Page.of(query.getCurrent(), query.getLimit());
        return page(page, queryWrapper);
    }

    private static void fillQueryWrapper(LogininforQuery query, QueryWrapper<Logininfor> queryWrapper) {
        //自动组装查询条件，生成orderBy，组装条件的两种方式：1.基于注解 2.基于query对象中属性的后缀
        OmpDbUtil.autoWrapper(query, queryWrapper, Logininfor.class);
    }
}




