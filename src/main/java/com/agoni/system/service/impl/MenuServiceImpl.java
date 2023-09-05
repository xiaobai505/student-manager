package com.agoni.system.service.impl;

import com.agoni.core.diboot.Binder;
import com.agoni.system.mapper.MenuMapper;
import com.agoni.system.model.po.Menu;
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

    private static final String AUTHS = "auths";

    /**
     * 根据 权限cede 查找
     *
     * @return menu菜单
     */
    @Override
    public List<MenuTreeVo> getTree() {
        // 转换vo
        List<MenuTreeVo> menuTreeVos = Binder.convertAndBindRelations(setAuthority(list()), MenuTreeVo.class);
        // 构建树
        return BeanUtils.buildTree(menuTreeVos);
    }
    
    /**
     * 给路由增加权限
     * @param menus
     */
    private List<Menu> setAuthority(List<Menu> menus) {
        // 先加默认的，后期根据角色设置菜单权限
        menus.forEach(menu -> {
            JSONObject meta = menu.getMeta();
            meta.put(AUTHS, UserUtil.getRoles());
            menu.setMeta(meta);
        });
        return menus;
    }
}




