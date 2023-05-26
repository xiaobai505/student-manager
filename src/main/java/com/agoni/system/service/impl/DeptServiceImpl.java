package com.agoni.system.service.impl;

import com.agoni.core.diboot.Binder;
import com.agoni.dgy.model.query.DeptQuery;
import com.agoni.dgy.model.vo.DeptVo;
import com.agoni.system.mapper.DeptMapper;
import com.agoni.system.model.po.Dept;
import com.agoni.system.service.DeptService;
import com.agoni.system.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gyd
 * @description 针对表【sys_dept(分校部门表)】的数据库操作Service实现
 * @createDate 2022-07-07 01:19:03
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
    
    @Autowired
    private UserService userService;
    
    /**
     * 根据 dq 查询 list
     *
     * @param dq
     *
     * @return
     */
    @Override
    public List<DeptVo> listByQuery(DeptQuery dq) {
        List<Dept> list = list(getDeptQueryWrapper(dq));
        return Binder.convertAndBindRelations(list, DeptVo.class);
    }
    
    @NotNull
    private QueryWrapper<Dept> getDeptQueryWrapper(DeptQuery dq) {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(StringUtils.isNotBlank(dq.getStatus()),Dept::getStatus, dq.getStatus())
                .eq(StringUtils.isNotBlank(dq.getName()),Dept::getName,dq.getName()).orderByAsc(Dept::getSort);
        return queryWrapper;
    }
    
    /**
     * 保存更新部门
     *
     * @param dept
     *
     * @return
     */
    @Override
    public Boolean saveDept(Dept dept) {
        // 上级部门信息
        Dept info = this.getById(dept.getParentId());
        // 如果父节点不为正常状态,则不允许新增子节点
        if ("1".equals(info.getStatus().toString())) {
            throw new RuntimeException("部门停用，不允许新增");
        }
        dept.setAncestors(info.getAncestors() + "," + dept.getParentId());
        return this.saveOrUpdate(dept);
    }
}




