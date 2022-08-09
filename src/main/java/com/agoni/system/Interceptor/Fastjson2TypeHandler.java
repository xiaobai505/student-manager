package com.agoni.system.Interceptor;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.extension.handlers.AbstractJsonTypeHandler;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 为了解决 mybatis-puls json对象 不兼容fastjson2的问题
 * （typeHandler = FastjsonTypeHandler.class）
 * @author gyd
 */
@MappedTypes({Object.class})
@MappedJdbcTypes({JdbcType.VARCHAR})
public class Fastjson2TypeHandler extends AbstractJsonTypeHandler<Object> {
    private static final Logger log = LoggerFactory.getLogger(FastjsonTypeHandler.class);
    private final Class<?> type;
    
    public Fastjson2TypeHandler(Class<?> type) {
        if (log.isTraceEnabled()) {
            log.trace("FastjsonTypeHandler(" + type + ")");
        }
        
        Assert.notNull(type, "Type argument cannot be null", new Object[0]);
        this.type = type;
    }
    
    /**
     * @param json 变成 fastjson2
     *
     * @return
     */
    @Override
    protected Object parse(String json) {
        return JSON.parseObject(json, this.type);
    }
    
    /**
     * @param obj 变成 fastjson2
     *
     * @return
     */
    @Override
    protected String toJson(Object obj) {
        return JSON.toJSONString(obj);
    }
    
    
}
