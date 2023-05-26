package com.agoni.system.mapper;

import com.agoni.system.model.po.OperLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Admin
* @description 针对表【sys_oper_log(操作日志记录)】的数据库操作Mapper
* @createDate 2022-08-31 16:29:43
* @Entity generator.domain.OperLog
*/
@Mapper
public interface OperLogMapper extends BaseMapper<OperLog> {

}




