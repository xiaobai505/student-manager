package com.agoni.dgy.service.impl;

import com.agoni.core.Binder;
import com.agoni.dgy.mapper.MenuMapper;
import com.agoni.dgy.model.bo.MenuFrom;
import com.agoni.dgy.model.po.Menu;
import com.agoni.dgy.model.vo.MenuTreeVo;
import com.agoni.dgy.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.diboot.core.util.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gyd
 * @description 针对表【tb_menu(菜单表)】的数据库操作Service实现
 * @createDate 2022-08-06 19:36:33
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    
    /**
     * 根据 权限cede 查找
     *
     * @return menu菜单
     */
    @Override
    public List<MenuTreeVo> getTree(MenuFrom from) {
        List<Menu> list = baseMapper.getByMenuFrom(from);
        // 转换vo
        List<MenuTreeVo> menuTreeVos = Binder.convertAndBindRelations(list, MenuTreeVo.class);
        // 构建树
        return BeanUtils.buildTree(menuTreeVos);
    }
    
    
    
}




