package com.agoni.dgy.service.impl;

import com.agoni.core.Binder;
import com.agoni.dgy.mapper.MenuMapper;
import com.agoni.dgy.model.po.Menu;
import com.agoni.dgy.model.query.MenuQuery;
import com.agoni.dgy.model.vo.MenuTreeVo;
import com.agoni.dgy.service.MenuService;
import com.agoni.system.utils.UserUtil;
import com.alibaba.fastjson2.JSONObject;
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
    public List<MenuTreeVo> getTree(MenuQuery from) {
        List<Menu> menus = baseMapper.getByMenuFrom(from);
        setAuthority(menus);
        // 转换vo
        List<MenuTreeVo> menuTreeVos = Binder.convertAndBindRelations(menus, MenuTreeVo.class);
        // 构建树
        return BeanUtils.buildTree(menuTreeVos);
    }
    
    /**
     * 给路由增加权限
     * @param menus
     */
    private static void setAuthority(List<Menu> menus) {
        // 用户选择的一个权限
        menus.forEach(menu -> {
            JSONObject meta = menu.getMeta();
            List autchority = (List) meta.get("authority");
            // autchority != null 说明有 authority 的属性
            if (autchority != null) {
                meta.put("authority", UserUtil.getRoles());
                menu.setMeta(meta);
            }
        });
    }
    
    
}




