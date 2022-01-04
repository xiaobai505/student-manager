package com.agoni.dgy.mapper;

import com.agoni.dgy.model.po.Major;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author gyd
* @description 针对表【tb_major(班级表)】的数据库操作Mapper
* @createDate 2022-01-04 20:36:49
* @Entity generator.domain.TbMajor
*/
@Mapper
public interface MajorMapper extends BaseMapper<Major> {


}
