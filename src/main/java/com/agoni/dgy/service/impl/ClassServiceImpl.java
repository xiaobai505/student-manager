package com.agoni.dgy.service.impl;

import com.agoni.dgy.model.po.Class;
import com.agoni.dgy.mapper.ClassMapper;
import com.agoni.dgy.service.ClassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 班级表 服务实现类
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements ClassService {

    @Autowired
    private ClassMapper classMapper;

    @Override
    public void selectpage() {
        List<Map> selectpage = classMapper.selectpage();
        System.out.printf("");

    }
}
