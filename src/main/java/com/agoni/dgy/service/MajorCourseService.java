package com.agoni.dgy.service;

import com.agoni.dgy.model.po.MajorCourse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author gyd
* @description 针对表【tb_major_course(专业课程关联表)】的数据库操作Service
* @createDate 2022-09-28 14:12:58
*/
public interface MajorCourseService extends IService<MajorCourse> {
    
    /**
     *  根据 majorId 查询 关联关系
     * @param majorId
     *
     * @return
     */
    List<MajorCourse> getByMajorId(Long majorId);
    
    /**
     * 根据 majorId 保存 相关课程
     * @param majorId
     * @param ids
     *
     * @return
     */
    boolean setCoursesByMajorId(Long majorId,List<Long> ids);

}
