package com.agoni.dgy.service.impl;

import com.agoni.dgy.mapper.ResultMapper;
import com.agoni.dgy.model.bo.ResultSearchFrom;
import com.agoni.dgy.model.po.Result;
import com.agoni.dgy.model.vo.ResultVo;
import com.agoni.dgy.service.ResultService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.diboot.core.binding.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private ResultMapper resultMapper;
    
    @Override
    public IPage<ResultVo> searchPage(ResultSearchFrom from) {
        QueryWrapper<Result> query = new QueryWrapper<>();
        QueryWrapper<Result> queryWrapper = QueryBuilder.toQueryWrapper(from);
        //query.lambda().likeRight(StringUtils.isNotEmpty(from.getClassName()), Result::getStudentName, from.getClassName());
        //return page(from, queryWrapper);
        return resultMapper.getPageToVo(from,from);
    }
}
