package com.agoni.dgy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.agoni.dgy.model.po.Menu;
import com.agoni.dgy.service.MenuService;
import com.agoni.dgy.mapper.MenuMapper;
import org.springframework.stereotype.Service;

/**
 * @author gyd
 * @description 针对表【tb_menutree(菜单表)】的数据库操作Service实现
 * @createDate 2022-08-06 19:36:33
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}



