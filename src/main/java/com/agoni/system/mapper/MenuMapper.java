package com.agoni.system.mapper;

import com.agoni.system.model.po.Menu;
import com.agoni.system.model.query.MenuQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author gyd
* @description 针对表【sys_menutree(菜单表)】的数据库操作Mapper
* @createDate 2022-08-06 19:36:33
* @Entity generator.domain.Menutree
*/
public interface MenuMapper extends BaseMapper<Menu> {
    
    List<Menu> getByMenuFrom(@Param("from") MenuQuery from);
}




