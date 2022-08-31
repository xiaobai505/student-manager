package com.agoni.dgy.service.impl;

import com.agoni.dgy.mapper.OperLogMapper;
import com.agoni.dgy.model.po.OperLog;
import com.agoni.dgy.service.OperLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author Admin
* @description 针对表【tb_oper_log(操作日志记录)】的数据库操作Service实现
* @createDate 2022-08-31 16:29:43
*/
@Service
public class OperLogServiceImpl extends ServiceImpl<OperLogMapper, OperLog>
    implements OperLogService{

}




