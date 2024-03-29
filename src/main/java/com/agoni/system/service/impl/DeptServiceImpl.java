package com.agoni.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.agoni.core.diboot.Binder;
import com.agoni.system.mapper.DeptMapper;
import com.agoni.system.model.po.Dept;
import com.agoni.system.model.vo.DeptVo;
import com.agoni.system.service.DeptService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gyd
 * @description 针对表【sys_dept(分校部门表)】的数据库操作Service实现
 * @createDate 2022-07-07 01:19:03
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
    
    @Override
    @Cacheable(value = "dept")
    public List<DeptVo> listByQuery() {
        return Binder.convertAndBindRelations(this.list(), DeptVo.class);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = "dept", allEntries = true)
    public Boolean saveOrUpdateDept(Dept dept) {
        // 有上级部门信息
        if (dept.getParentId() != 0) {
            Dept info = this.getById(dept.getParentId());
            dept.setAncestors(info.getAncestors() + StrUtil.COMMA + dept.getParentId());
        }
        return this.saveOrUpdate(dept);
    }

    @Override
    public List<Long> getChildDeptIds(Long deptId) {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().select(Dept::getId).apply("find_in_set({0}, ancestors)", deptId);
        return list(queryWrapper).stream().map(Dept::getId).collect(Collectors.toList());
    }


}




