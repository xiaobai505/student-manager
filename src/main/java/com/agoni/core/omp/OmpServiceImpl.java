package com.agoni.core.omp;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * TODO
 * </p>
 *
 * @author t-guoyu.dong@pcitc.com
 * @since 2023/6/6
 */
@Slf4j
public class OmpServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements IService<T> {
    /**
     * 重写了IService中的remove方法,是因为直接调用remove,不会去更新update_by等更新字段
     * 而且直接用remove方法,批量更新可能会锁表
     *
     * @param wrapper 条件构造器
     * @return boolean 执行结果
     * @author dgy
     * @date 2023/06/06
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean remove(Wrapper<T> wrapper) {
        TableInfo tableInfo = TableInfoHelper.getTableInfo(getEntityClass());
        if (tableInfo.isWithLogicDelete() && tableInfo.isWithUpdateFill()) {
            wrapper = setWrapperSelect(wrapper);
            // 如果是逻辑删除，先查出来 然后通过id删除 否则自动注入不生效
            List<T> list = list(wrapper);
            if (CollUtil.isNotEmpty(list)) {
                String key = tableInfo.getKeyProperty();
                List<Object> ids = list.stream().map(t -> BeanUtil.getProperty(t, key)).collect(Collectors.toList());
                return removeBatchByIds(ids);
            }
        }
        return SqlHelper.retBool(getBaseMapper().delete(wrapper));
    }

    /**
     * 这个方法是为了保证查询提高效率,只查出主键id字段,而不是所有字段
     *
     * @param wrapper wrapper
     * @return com.baomidou.mybatisplus.core.conditions.Wrapper<T>
     * @author Star Walker
     * @date 2023/06/06
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    private Wrapper<T> setWrapperSelect(Wrapper<T> wrapper) {
        TableInfo tableInfo = TableInfoHelper.getTableInfo(getEntityClass());
        String keyColumn = tableInfo.getKeyColumn();
        if (wrapper instanceof QueryWrapper) {
            QueryWrapper<T> queryWrapper = (QueryWrapper) wrapper;
            queryWrapper.select(keyColumn);
            return queryWrapper;
        }
        if (wrapper instanceof LambdaQueryWrapper) {
            LambdaQueryWrapper<T> lambdaQueryWrapper = (LambdaQueryWrapper) wrapper;
            lambdaQueryWrapper.select(getEntityClass(), tableFieldInfo -> keyColumn.equals(tableFieldInfo.getColumn()));
            return lambdaQueryWrapper;
        }
        log.warn("请注意,尽量使用QueryWrapper和LambdaQueryWrapper来进行remove操作!");
        return wrapper;
    }

    public IPage<T> getPage(Object query) {
        Integer current = (Integer) ReflectUtil.getFieldValue(query, "current");
        Integer limit = (Integer) ReflectUtil.getFieldValue(query, "size");
        if (ObjectUtil.isEmpty(current) || ObjectUtil.isEmpty(limit)) {
            log.error("分页查询参数错误");
        }
        Page<T> page = Page.of(current, limit);
        QueryWrapper<T> queryWrapper = Wrappers.query();
        OmpDbUtil.autoWrapper(query, queryWrapper, getEntityClass());
        return page(page, queryWrapper);
    }

    public List<T> getList(Object query) {
        QueryWrapper<T> queryWrapper = Wrappers.query();
        OmpDbUtil.autoWrapper(query, queryWrapper, getEntityClass());
        return this.list();
    }

}