package com.agoni.dgy.service.impl;

import com.agoni.core.RelationsBinder;
import com.agoni.dgy.mapper.DictMapper;
import com.agoni.dgy.model.po.Dict;
import com.agoni.dgy.model.po.DictConfig;
import com.agoni.dgy.service.DictConfigService;
import com.agoni.dgy.service.DictService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.diboot.core.util.BeanUtils;
import com.diboot.core.util.S;
import com.diboot.core.util.V;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* @author Admin
* @description 针对表【tb_dict】的数据库操作Service实现
* @createDate 2022-06-30 17:19:03
*/
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService{
    
    @Autowired
    private DictConfigService dictConfigService;
    
    @Override
    @Transient
    public boolean del(long id) {
        Dict dict = this.getById(id);
        if (dict.getParentId()!=0){
            new RuntimeException("先删除子类");
        }
        // 1：删除 dictConfig 的配置
        dictConfigService.delDictId(dict.getId());
        // 2：删除 dict
        return this.removeById(id);
    }
    
    @Override
    @Transient
    public List<DictConfig> getConfigByType(String type) {
        LambdaQueryWrapper<Dict> query= new LambdaQueryWrapper<>();
        query.eq(Dict::getModel,type);
        Dict dict = this.getOne(query);
        List<DictConfig> dictConfigs = dictConfigService.getDictId(dict.getId());
        return dictConfigs;
    }
    
    
    @Override
    public void bindItemLabel(List voList, String setFieldName, String getFieldName, String type) {
        if (!V.isEmpty(voList)) {
            List<DictConfig> entityList = this.getConfigByType(type);
            if (V.isEmpty(voList)) {return;}
            Map<String, String> map = entityList.stream().collect(Collectors.toMap(DictConfig::getDictValue, DictConfig::getDictDisplay));
            Iterator var8 = voList.iterator();
            while(true) {
                Object item;
                String value;
                do {
                    if (!var8.hasNext()) {
                        return;
                    }
                    item = var8.next();
                    value = BeanUtils.getStringProperty(item, getFieldName);
                } while(V.isEmpty(value));
            
                String label = (String)map.get(value);
                if (label == null && value.contains(",")) {
                    ArrayList<String> labelList = new ArrayList();
                    String[] var13 = value.split(",");
                    int var14 = var13.length;
                
                    for(int var15 = 0; var15 < var14; ++var15) {
                        String key = var13[var15];
                        labelList.add(map.get(key));
                    }
                
                    label = S.join(labelList);
                }
            
                if (S.isNotEmpty(label)) {
                    BeanUtils.setProperty(item, setFieldName, label);
                }
            }
        }
    }
    
    
    public static <E, VO> List<VO> convertAndBindRelations(List<E> entityList, Class<VO> voClass){
        List<VO> voList = new ArrayList<>();
        if (CollectionUtils.isEmpty(entityList)) {
            return voList;
        }
        //return voList;
        return RelationsBinder.convertAndBind(entityList, voClass);
    }
}




