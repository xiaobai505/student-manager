package com.agoni.dgy.service.impl;

import com.agoni.dgy.mapper.ResultMapper;
import com.agoni.dgy.model.bo.ResultSearchFrom;
import com.agoni.dgy.model.po.Major;
import com.agoni.dgy.model.po.Result;
import com.agoni.dgy.service.ResultService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 成绩表 服务实现类
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Service
public class ResultServiceImpl extends ServiceImpl<ResultMapper, Result> implements ResultService {
    
    @Override
    public IPage<Major> searchPage(ResultSearchFrom from) {
        QueryWrapper<Result> query = new QueryWrapper<>();
        query.lambda().likeRight(StringUtils.isNotEmpty(from.getClassName()), Result::getStudentName, from.getClassName());
        return page(from, query);
    }
}
