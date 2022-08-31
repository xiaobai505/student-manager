package com.agoni.dgy.service.impl;

import com.agoni.dgy.mapper.JobMapper;
import com.agoni.dgy.model.po.Job;
import com.agoni.dgy.service.JobService;
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




