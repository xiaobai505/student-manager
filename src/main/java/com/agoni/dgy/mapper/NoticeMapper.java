package com.agoni.dgy.mapper;

import com.agoni.dgy.model.po.Notice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Admin
* @description 针对表【tb_notice(通知公告表)】的数据库操作Mapper
* @createDate 2022-08-31 16:29:36
* @Entity generator.domain.Notice
*/
@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {

}




