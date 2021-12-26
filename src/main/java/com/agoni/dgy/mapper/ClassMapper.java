package com.agoni.dgy.mapper;

import com.agoni.dgy.model.po.Class;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 班级表 Mapper 接口
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Mapper
public interface ClassMapper extends BaseMapper<Class> {

    @Select("SELECT * FROM tb_class WHERE del_flag=0")
    List<Map>  selectpage();
}
