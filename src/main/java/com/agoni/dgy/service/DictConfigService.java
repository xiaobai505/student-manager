package com.agoni.dgy.service;

import com.agoni.dgy.model.po.DictConfig;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author gyd
* @description 针对表【tb_dict_config(字典详细表)】的数据库操作Service
* @createDate 2022-07-24 23:20:40
*/
public interface DictConfigService extends IService<DictConfig> {
    
    List<DictConfig> getDictId(long id);
    
    boolean delDictId(long id);

}
