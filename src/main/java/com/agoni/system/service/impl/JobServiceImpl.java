package com.agoni.system.service.impl;

import com.agoni.system.mapper.JobMapper;
import com.agoni.system.model.po.Job;
import com.agoni.system.service.JobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author Admin
* @description 针对表【tb_job(定时任务调度表)】的数据库操作Service实现
* @createDate 2022-08-31 16:29:20
*/
@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job>
    implements JobService{

}




