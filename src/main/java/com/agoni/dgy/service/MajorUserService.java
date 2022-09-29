package com.agoni.dgy.service;

import com.agoni.dgy.model.po.MajorUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户-专业  服务类
 * </p>
 *
 * @author dgy
 * @since 2021-12-27
 */
public interface MajorUserService extends IService<MajorUser> {
    
    /**
     * 根据条件查询 用户-专业 关联关系
     * @param from
     *
     * @return
     */
    List<MajorUser> getlist(MajorUser mu);

}
