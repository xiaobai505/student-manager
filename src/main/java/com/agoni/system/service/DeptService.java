package com.agoni.system.service;

import com.agoni.system.model.po.Dept;
import com.agoni.system.model.vo.DeptVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author gyd
 * @description 针对表【sys_dept(分校部门表)】的数据库操作Service
 * @createDate 2022-07-07 01:19:03
 */
public interface DeptService extends IService<Dept> {
    
    /**
     * 查询 list
     *
     * @return
     */
    List<DeptVo> listByQuery();
    
    /**
     * 保存更新部门
     * @param dept
     *
     * @return
     */
    Boolean saveOrUpdateDept(Dept dept);
}
