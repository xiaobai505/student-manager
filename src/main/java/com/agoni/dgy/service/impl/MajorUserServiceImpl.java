package com.agoni.dgy.service.impl;

import com.agoni.dgy.mapper.MajorUserMapper;
import com.agoni.dgy.model.po.MajorUser;
import com.agoni.dgy.service.MajorUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户角色关系表 服务实现类
 * </p>
 *
 * @author dgy
 * @since 2021-12-27
 */
@Service
public class MajorUserServiceImpl extends ServiceImpl<MajorUserMapper, MajorUser> implements MajorUserService {
    
    /**
     * 根据条件查询 用户-专业 关联关系
     *
     * @param from
     *
     * @return
     */
    @Override
    public List<MajorUser> getlist(MajorUser mu) {
        QueryWrapper<MajorUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(ObjectUtils.isNotNull(mu.getUserId()),MajorUser::getUserId,mu.getUserId())
                    .eq(ObjectUtils.isNotNull(mu.getMajorId()),MajorUser::getMajorId,mu.getMajorId());
        return list(queryWrapper);
    }
}
