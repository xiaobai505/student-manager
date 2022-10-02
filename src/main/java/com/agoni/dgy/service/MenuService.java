package com.agoni.dgy.service;

import com.agoni.dgy.model.po.Menu;
import com.agoni.dgy.model.query.MenuQuery;
import com.agoni.dgy.model.vo.MenuTreeVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author gyd
* @description 针对表【tb_menu(菜单表)】的数据库操作Service
* @createDate 2022-08-06 19:36:33
*/
public interface MenuService extends IService<Menu> {
    
    /**
     * 根据 权限cede 查找
     * @return menu菜单
     */
    List<MenuTreeVo> getTree(MenuQuery from);
    
}
