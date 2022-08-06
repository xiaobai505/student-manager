package com.agoni.dgy.service.impl;

import com.agoni.core.Binder;
import com.agoni.dgy.mapper.CourseUserMapper;
import com.agoni.dgy.model.bo.CourseUserSearchFrom;
import com.agoni.dgy.model.po.AbstractEntity;
import com.agoni.dgy.model.po.Course;
import com.agoni.dgy.model.po.CourseUser;
import com.agoni.dgy.model.vo.AuthUserVo;
import com.agoni.dgy.model.vo.CourseUserVo;
import com.agoni.dgy.service.CourseService;
import com.agoni.dgy.service.CourseUserService;
import com.agoni.security.utils.UserUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.beans.Transient;
import java.util.List;
import java.util.stream.Collectors;

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
public class CourseUserServiceImpl extends ServiceImpl<CourseUserMapper, CourseUser> implements CourseUserService {
    
    @Autowired
    private CourseUserMapper courseUserMapper;
    
    @Autowired
    private CourseService courseService;
    
    @Override
    public List<CourseUserVo> mylist() {
        AuthUserVo userVo = UserUtil.getUser();
        SimpleGrantedAuthority admin = new SimpleGrantedAuthority("admin");
        if (userVo.getAuthorities().contains(admin)) {
            log.info("我拥有管理员权限！查询所有！");
            return courseUserMapper.mylist(null);
        }
        return courseUserMapper.mylist(userVo.getId());
    }
    
    @Override
    public IPage<CourseUserVo> searchPage(CourseUserSearchFrom from) {
        // 根据 名称 查找 课程id
        List<Course> courses = courseService.listByCourseName(from.getCourseName());
        List<Long> ids = courses.stream().map(Course::getId).collect(Collectors.toList());
        // 根据 课程id 查找 选课信息
        QueryWrapper<CourseUser> query = new QueryWrapper<>();
        query.lambda().in(CollectionUtils.isEmpty(ids), CourseUser::getCourseId, ids).orderByDesc(AbstractEntity::getCreateTime);
        return Binder.convertAndBindRelations(page(from, query),CourseUserVo.class);
    }
    
    @Override
    @Transient
    public boolean saveCourse(Long id) {
        // 校验座位数量
        Course course = courseService.checkStock(id);
        // 减座位数量
        courseService.saleStock(course);
        // 保存记录
        AuthUserVo user = UserUtil.getUser();
        CourseUser build = CourseUser.builder().userId(user.getId()).courseId(id).build();
        return this.save(build);
    }
    
    @Override
    public boolean deleteById(CourseUser courseUser) {
        // 增加座位数量
        courseService.delStock(courseUser.getCourseId());
        // 删除记录
        return this.removeById(courseUser.getId());
    }
}
