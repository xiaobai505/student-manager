package com.agoni.core.diboot.AccessPermission;

import cn.hutool.core.util.ObjectUtil;
import com.agoni.core.exception.BusinessException;
import com.agoni.system.model.po.User;
import com.agoni.system.utils.UserUtil;
import com.diboot.core.config.Cons;
import com.diboot.core.data.access.DataScopeManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.agoni.core.exception.enums.BusinessBaseEnum.START_ERROR;

/**
 * 数据范围权限控制
 */
@Slf4j
@Component
public class MyDataAccessPermissionImpl implements DataScopeManager {

    @Override
    public List<? extends Serializable> getAccessibleIds(String entityClassName, String fieldName) {
        // @DataAccessCheckpoint 在po上才会执行
        // -Dspring.security.strategy=MODE_INHERITABLETHREADLOCAL
        // 子线程user==null，需要增加上面的参数
        log.error("执行了数据权限过滤！");
        User user = UserUtil.getUser();
        if (ObjectUtil.isEmpty(user)) {
            throw new BusinessException(START_ERROR);
        }
        // 提取其可访问ids
        List<Serializable> accessibleIds = new ArrayList<>();
        //按部门过滤
        if(Cons.FieldName.orgId.name().equals(fieldName)){
            // 示例：可访问数据范围为: orgId 为 当前部门ID 或 子部门 IDs
            String deptId = user.getDeptId();
            accessibleIds.add(deptId);
            // 获取当前部门的子部门ID集合
            // accessibleIds.addAll(childOrgIds);
        }
        // 按用户过滤
        if(Cons.FieldName.userId.name().equals(fieldName)){
            //示例：可访问数据范围为: 本人
            accessibleIds.add(user.getId());
        }
        // 按其他字段过滤...

        // 返回合法ID集合
        return accessibleIds;
    }
}
