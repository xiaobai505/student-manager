package com.agoni.dgy.service.impl;

import com.agoni.dgy.mapper.MajorCourseMapper;
import com.agoni.dgy.model.po.MajorCourse;
import com.agoni.dgy.service.MajorCourseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author gyd
* @description 针对表【tb_major_course(专业课程关联表)】的数据库操作Service实现
* @createDate 2022-09-28 14:12:58
*/
@Service
public class MajorCourseServiceImpl extends ServiceImpl<MajorCourseMapper, MajorCourse> implements MajorCourseService {
    
    /**
     *  根据 majorId 查询 关联关系
     * @param majorId
     *
     * @return
     */
    @Override
    public List<MajorCourse> getByMajorId(Long majorId) {
        QueryWrapper<MajorCourse> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(MajorCourse::getMajorId,majorId);
        List<MajorCourse> list = list(queryWrapper);
        return list;
    }
    
    /**
     * 根据 majorId 保存 相关课程
     * @param majorId
     * @param ids
     *
     * @return
     */
    @Override
    public boolean setCoursesByMajorId(Long majorId, List<Long> ids) {
        // 删除原来的课程
        QueryWrapper<MajorCourse> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(MajorCourse::getMajorId,majorId);
        boolean b1 = this.remove(queryWrapper);
    
        // 新增课程
        List<MajorCourse> infos= new ArrayList<>();
        ids.forEach(id->infos.add(MajorCourse.builder().majorId(majorId).courseId(id).build()));
        boolean b2 = this.saveBatch(infos);
        return b1 && b2;
    }
}




