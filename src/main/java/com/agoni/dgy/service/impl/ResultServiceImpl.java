package com.agoni.dgy.service.impl;

import com.agoni.core.diboot.Binder;
import com.agoni.dgy.mapper.ResultMapper;
import com.agoni.dgy.model.po.Result;
import com.agoni.dgy.model.query.ResultPageQuery;
import com.agoni.dgy.model.vo.ResultVo;
import com.agoni.dgy.service.ResultService;
import com.agoni.system.model.po.Menu;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.StringJoiner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 成绩表 服务实现类
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Service
public class ResultServiceImpl extends ServiceImpl<ResultMapper, Result> implements ResultService {
    
    @Autowired
    private ResultMapper resultMapper;
    
    @Override
    public IPage<ResultVo> searchPage(ResultPageQuery query) {
        QueryWrapper<Result> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().likeLeft(StringUtils.isNotEmpty(query.getCourseName()),Result::getCourseName,query.getCourseName())
             .orderByDesc(Result::getCreateTime);
        Page<Result> page = Page.of(query.getCurrentPage(), query.getPageSize());
        Page<Result> resultPage = page(page, queryWrapper);
        return Binder.convertAndBindRelations(resultPage, ResultVo.class);
    }
    
    /**
     * 根据课程ID删除
     * @param cId
     *
     * @return
     */
    @Override
    public boolean delByCourseId(long cId) {
        QueryWrapper<Result> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Result::getCourseId,cId);
        return this.remove(queryWrapper);
    }
    
    /**
     * @return
     */
    @Override
    @Async("dgy")
    public CompletableFuture<String> test(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        printimeAndThread("吃饭"+i);
        return AsyncResult.forValue("dgy.test-" + i).completable();
    }
    
    /**
     *
     */
    @Override
    public Menu test5() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        printimeAndThread("吃饭"+5);
        return Menu.builder().id(5L).name("5").build();
    }
    
    /**
     *
     */
    @Override
    public Menu test2() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        printimeAndThread("吃饭"+2);
        return Menu.builder().id(2L).name("2").build();
    }
    
    
    public static void printimeAndThread(String tag){
        String res=new StringJoiner("\t|\t")
                .add(String.valueOf(System.currentTimeMillis()))
                .add(String.valueOf(Thread.currentThread().getId()))
                .add(Thread.currentThread().getName())
                .add(tag)
                .toString();
        System.out.println(res);
    }
}
