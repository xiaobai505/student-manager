package com.agoni.dgy.service.impl;

import com.agoni.dgy.dao.TbClassDao;
import com.agoni.dgy.model.TbClass;
import com.agoni.dgy.service.TbCourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public PageInfo<TbClass> selectAll(){
        PageHelper.startPage(1, 5);
        List<TbClass> tbClasses = tbClassDao.selectAll();
        // 3.获取详细分页信息
        PageInfo<TbClass> pageInfo = new PageInfo<>(tbClasses);
        return pageInfo;
    }

}
