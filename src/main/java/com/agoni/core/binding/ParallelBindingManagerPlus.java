package com.agoni.core.binding;

import com.agoni.dgy.service.DictService;
import com.diboot.core.binding.annotation.BindDict;
import com.diboot.core.binding.binder.parallel.ParallelBindingManager;
import com.diboot.core.binding.parser.FieldAnnotation;
import com.diboot.core.exception.InvalidUsageException;
import com.diboot.core.util.S;
import com.diboot.core.util.V;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * 并行绑定Manager
 * @author JerryMa
 * @version v2.4.0
 * @date 2021/11/16
 * Copyright © diboot.com
 */
@Slf4j
@Component
public class ParallelBindingManagerPlus extends ParallelBindingManager {
    
    @Autowired(required = false)
    private DictService dictService;
    
    
    /**
     * 绑定字典
     * @param voList
     * @param fieldAnno
     * @return
     */
    @Async
    @Override
    public CompletableFuture<Boolean> doBindingDict(List voList, FieldAnnotation fieldAnno){
        if(dictService != null){
            BindDict annotation = (BindDict) fieldAnno.getAnnotation();
            String dictValueField = annotation.field();
            if(V.isEmpty(dictValueField)){
                dictValueField = S.replace(fieldAnno.getFieldName(), "Label", "");
                log.debug("BindDict未指定field，将默认取值为: {}", dictValueField);
            }
            // 字典绑定接口化
            dictService.bindItemLabel(voList, fieldAnno.getFieldName(), dictValueField, annotation.type());
        }
        else{
            throw new InvalidUsageException("BindDictService未实现，无法使用BindDict注解！");
        }
        return CompletableFuture.completedFuture(true);
    }
    
}