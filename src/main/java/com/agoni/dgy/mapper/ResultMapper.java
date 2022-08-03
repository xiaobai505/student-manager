package com.agoni.dgy.mapper;

import com.agoni.dgy.model.bo.ResultSearchFrom;
import com.agoni.dgy.model.po.Result;
import com.agoni.dgy.model.vo.ResultVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 成绩表 Mapper 接口
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Mapper
public interface ResultMapper extends BaseMapper<Result> {
    
    IPage<ResultVo> getPageToVo (Page page, @Param("from") ResultSearchFrom from);
}
