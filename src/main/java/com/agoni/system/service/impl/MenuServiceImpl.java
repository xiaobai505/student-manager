package com.agoni.system.service.impl;

import com.agoni.core.diboot.Binder;
import com.agoni.system.mapper.MenuMapper;
import com.agoni.system.model.po.Menu;
import com.agoni.system.model.query.MenuQuery;
import com.agoni.system.model.vo.MenuTreeVo;
import com.agoni.system.service.MenuService;
import com.agoni.system.utils.UserUtil;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.diboot.core.util.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gyd
 * @description 针对表【sys_menu(菜单表)】的数据库操作Service实现
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




