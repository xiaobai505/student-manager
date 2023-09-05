package com.agoni.system.mapper;

import com.agoni.system.model.po.JobLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Admin
* @description 针对表【tb_job_log(定时任务调度日志表)】的数据库操作Mapper
* @createDate 2022-08-31 16:29:20
* @Entity generator.domain.JobLog
*/
@Mapper
public interface JobLogMapper extends BaseMapper<JobLog> {

}




