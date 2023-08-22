package com.agoni.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.agoni.core.diboot.Binder;
import com.agoni.system.mapper.DeptMapper;
import com.agoni.system.model.po.Dept;
import com.agoni.system.model.vo.DeptVo;
import com.agoni.system.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author gyd
 * @description 针对表【sys_dept(分校部门表)】的数据库操作Service实现
 * @createDate 2022-07-07 01:19:03
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
    
    @Override
    public List<DeptVo> listByQuery() {
        return Binder.convertAndBindRelations(this.list(), DeptVo.class);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean saveOrUpdateDept(Dept dept) {
        // 上级部门信息
        Dept info = this.getById(dept.getParentId());
        // 如果父节点不为正常状态,则不允许新增子节点
        if (info.getStatus() == 0) {
            throw new RuntimeException("部门停用，不允许新增");
        }
        dept.setAncestors(info.getAncestors() + StrUtil.COMMA + dept.getParentId());
        return this.saveOrUpdate(dept);
    }
}




