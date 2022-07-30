package com.agoni.dgy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.agoni.dgy.model.po.DictConfig;
import com.agoni.dgy.service.DictConfigService;
import com.agoni.dgy.mapper.DictConfigMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author gyd
* @description 针对表【tb_dict_config(字典详细表)】的数据库操作Service实现
* @createDate 2022-07-24 23:20:40
*/
@Service
public class DictConfigServiceImpl extends ServiceImpl<DictConfigMapper, DictConfig>
    implements DictConfigService{
    
    @Override
    public List<DictConfig> getDictId(long id) {
        QueryWrapper<DictConfig> query = new QueryWrapper<>();
        query.lambda().eq(DictConfig::getDictId,id);
        return this.list(query);
    }
    
    @Override
    public boolean delDictId(long id) {
        return false;
    }
}




