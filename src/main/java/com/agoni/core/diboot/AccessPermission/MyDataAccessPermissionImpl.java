package com.agoni.core.diboot.AccessPermission;

import com.diboot.core.data.access.DataAccessInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * 数据范围权限控制
 */
@Slf4j
@Component
public class MyDataAccessPermissionImpl implements DataAccessInterface {
    /**
     * 实现DataAccessInterface接口，返回当前用户可访问的合法ID集合
     * @param entityClass
     * @param fieldName
     * @return
     */
    @Override
    public List<? extends Serializable> getAccessibleIds(Class<?> entityClass, String fieldName) {
        log.error("执行了数据权限过滤！");
        return null;
    }
}
