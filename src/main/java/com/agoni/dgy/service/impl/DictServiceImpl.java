package com.agoni.dgy.service.impl;

import com.agoni.core.binding.RelationsBinder;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.agoni.dgy.model.po.Dict;
import com.agoni.dgy.service.DictService;
import com.agoni.dgy.mapper.DictMapper;
import com.diboot.core.entity.Dictionary;
import com.diboot.core.util.BeanUtils;
import com.diboot.core.util.S;
import com.diboot.core.util.V;
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
    
    @Override
    @Transient
    public boolean del(long id) {
        Dict dict = this.getById(id);
        this.removeById(dict.getParentId());
        return this.removeById(id);
    }
    
    @Override
    public void bindItemLabel(List voList, String setFieldName, String getFieldName, String type) {
        if (!V.isEmpty(voList)) {
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




