package com.agoni.dgy.service;

import com.agoni.dgy.model.po.Class;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 班级表 服务类
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Service
public interface ClassService extends IService<Class> {
    void selectpage();
}
