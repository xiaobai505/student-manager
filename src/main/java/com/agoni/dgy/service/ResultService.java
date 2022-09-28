package com.agoni.dgy.service;

import com.agoni.dgy.model.po.Menu;
import com.agoni.dgy.model.po.Result;
import com.agoni.dgy.model.query.ResultQuery;
import com.agoni.dgy.model.vo.ResultVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.concurrent.CompletableFuture;

/**
 * <p>
 * 成绩表 服务类
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
public interface ResultService extends IService<Result> {
    
    IPage<ResultVo> searchPage(ResultQuery from);
    
    CompletableFuture<String> test(int i);
    
    Menu test5();
    
    Menu test2();
}
