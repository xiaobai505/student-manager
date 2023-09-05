package com.agoni.system.service.impl;

import com.agoni.system.mapper.JobLogMapper;
import com.agoni.system.model.po.JobLog;
import com.agoni.system.service.JobLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author Admin
* @description 针对表【tb_job_log(定时任务调度日志表)】的数据库操作Service实现
* @createDate 2022-08-31 16:29:20
*/
@Service
public class JobLogServiceImpl extends ServiceImpl<JobLogMapper, JobLog>
    implements JobLogService{

}




