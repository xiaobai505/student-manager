package com.agoni.dgy.service;

import com.agoni.dgy.model.bo.ResultSearchFrom;
import com.agoni.dgy.model.po.Major;
import com.agoni.dgy.model.po.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 成绩表 服务类
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
public interface ResultService extends IService<Result> {
    
    IPage<Major> searchPage(ResultSearchFrom from);
}
