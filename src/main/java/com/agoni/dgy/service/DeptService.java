package com.agoni.dgy.service;

import com.agoni.dgy.model.po.Dept;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author gyd
 * @description 针对表【tb_dept(分校部门表)】的数据库操作Service
 * @createDate 2022-07-07 01:19:03
 */
public interface DeptService extends IService<Dept> {
    
    /**
     * 保存更新部门
     * @param dept
     *
     * @return
     */
    Boolean saveDept(Dept dept);
}
