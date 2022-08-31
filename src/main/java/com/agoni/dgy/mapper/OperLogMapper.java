package com.agoni.dgy.mapper;

import com.agoni.dgy.model.po.OperLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Admin
* @description 针对表【tb_oper_log(操作日志记录)】的数据库操作Mapper
* @createDate 2022-08-31 16:29:43
* @Entity generator.domain.OperLog
*/
@Mapper
public interface OperLogMapper extends BaseMapper<OperLog> {

}




