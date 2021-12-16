package com.agoni.dgy.service.impl;

import com.agoni.dgy.dao.TbClassDao;
import com.agoni.dgy.model.TbClass;
import com.agoni.dgy.service.TbCourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TbCourseServiceImpl implements TbCourseService {

    @Resource
    private TbClassDao tbClassDao;
    /**
     * 根据id查询课程信息
     * @param id
     * @return TbCourse
     */
    @Override
    public TbClass selectByPrimaryKey(Integer id) {
        return tbClassDao.selectByPrimaryKey(id);
    }
}
