package com.agoni.dgy.mapper;

import com.agoni.dgy.model.po.Job;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Admin
* @description 针对表【tb_job(定时任务调度表)】的数据库操作Mapper
* @createDate 2022-08-31 16:29:20
* @Entity generator.domain.Job
*/
@Mapper
public interface JobMapper extends BaseMapper<Job> {

}




