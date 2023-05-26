package com.agoni.system.service;

import com.agoni.system.model.po.Menu;
import com.agoni.system.model.query.MenuQuery;
import com.agoni.system.model.vo.MenuTreeVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author gyd
* @description 针对表【sys_menu(菜单表)】的数据库操作Service
* @createDate 2022-08-06 19:36:33
*/
public interface MenuService extends IService<Menu> {
    
    /**
     * 根据 权限cede 查找
     * @return menu菜单
     */
    List<MenuTreeVo> getTree(MenuQuery from);
    
}
