package com.agoni.dgy.service;

import com.agoni.dgy.model.po.Dict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Admin
* @description 针对表【tb_dict】的数据库操作Service
* @createDate 2022-06-30 17:19:03
*/
public interface DictService extends IService<Dict> {
    
    boolean del(long id);
    
    void bindItemLabel(List voList, String setFieldName, String getFieldName, String type);
}
