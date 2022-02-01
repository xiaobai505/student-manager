package com.agoni.dgy.service;

import com.agoni.dgy.model.po.Major;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 班级表 服务类
 * </p>
 *
 * @author dgy
 * @since 2022-01-04
 */
public interface MajorService extends IService<Major> {

    List<Major> getSchoolList();
}
