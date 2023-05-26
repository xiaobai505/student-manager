package com.agoni.system.service.impl;

import com.agoni.system.mapper.DictConfigMapper;
import com.agoni.system.model.po.DictConfig;
import com.agoni.system.service.DictConfigService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author gyd
* @description 针对表【sys_dict_config(字典详细表)】的数据库操作Service实现
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




