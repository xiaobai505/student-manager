package com.agoni.dgy.service.impl;

import com.agoni.core.diboot.Binder;
import com.agoni.core.omp.OmpServiceImpl;
import com.agoni.dgy.mapper.CourseUserMapper;
import com.agoni.dgy.model.po.Course;
import com.agoni.dgy.model.po.CourseUser;
import com.agoni.dgy.model.po.Result;
import com.agoni.dgy.model.query.CourseUserQuery;
import com.agoni.dgy.model.vo.CourseUserVo;
import com.agoni.dgy.service.CourseService;
import com.agoni.dgy.service.CourseUserService;
import com.agoni.dgy.service.ResultService;
import com.agoni.system.model.po.User;
import com.agoni.system.utils.UserUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 用户课程关系表 服务实现类
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Service
@Slf4j
public class CourseUserServiceImpl extends OmpServiceImpl<CourseUserMapper, CourseUser> implements CourseUserService {

    @Autowired
    private CourseService courseService;
    
    @Autowired
    private ResultService resultService;

    @Override
    public IPage<CourseUserVo> searchPage(CourseUserQuery query) {
        Page<CourseUser> page = getPage(query);
        return Binder.convertAndBindRelations(page,CourseUserVo.class);
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveCourse(Long id) {
        // 校验座位数量
        Course c = courseService.checkStock(id);
        // 减座位数量
        courseService.saleStock(c);
        // 保存记录
        User u = UserUtil.getUser();
        // 增选选修课成绩信息
        Result r = Result.builder().userId(u.getId()).courseId(c.getId()).graduate(c.getGraduate())
                .courseName(c.getCourseName()).build();
        resultService.save(r);
        return this.save(CourseUser.builder().userId(u.getId()).courseId(id).build());
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(CourseUser courseUser) {
        // 增加座位数量
        courseService.delStock(courseUser.getCourseId());
        // 根据选修课程ID删除对应记录
        resultService.delByCourseId(courseUser.getCourseId());
        // 删除记录
        return this.removeById(courseUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteByCourseId(@NotNull Long id) {
        // 增加座位数量
        courseService.delStock(id);
        // 根据选修课程ID删除对应记录
        resultService.delByCourseId(id);
        // 删除记录
        User u = UserUtil.getUser();
        QueryWrapper<CourseUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(CourseUser::getCourseId, id).eq(CourseUser::getUserId, u.getId());
        return remove(queryWrapper);
    }
}









