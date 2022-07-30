package com.agoni.dgy.service;

import com.agoni.dgy.model.po.Dict;
import com.agoni.dgy.model.po.DictConfig;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Admin
* @description 针对表【tb_dict】的数据库操作Service
* @createDate 2022-06-30 17:19:03
*/
public interface DictService extends IService<Dict> {
    
    
    /**
     * 根据名字返回list
     * @param id 需要删除的id
     *
     * @return
     */
    boolean del(long id);
    
    /**
     * 根据 type类型 查询字典的config
     * @param type 字典的类型-注解上面type
     *
     * @return List<DictConfig>
     */
    List<DictConfig> getConfigByType(String type);
    
    /**
     * 根据名字返回list
     * @param voList 需要转换的list
     * @param setFieldName 需要写入的字段名字
     * @param getFieldName 获取需要转换的字段的名字
     * @param type 字典的类型-注解上面type
     *
     * @return
     */
    void bindItemLabel(List voList, String setFieldName, String getFieldName, String type);
    
    

}
