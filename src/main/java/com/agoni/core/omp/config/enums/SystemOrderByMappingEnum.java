package com.agoni.core.omp.config.enums;

import cn.hutool.core.map.MapUtil;

import java.util.HashMap;

public enum SystemOrderByMappingEnum implements OrderByEnumFunction {

    /**
     * 用户分页字段排序映射
     */
    USER(MapUtil.newHashMap()),
    /**
     * 用户分页字段排序映射
     */
    ROLE(MapUtil.newHashMap()),
    /**
     * 用户分页字段排序映射
     */
    NOTICE(MapUtil.newHashMap());

    static {
        USER.orderByMappingMap.put("orgName", "orgId");
        USER.orderByMappingMap.put("postName", "postId");
        USER.orderByMappingMap.put("userTypeName", "userType");
        ROLE.orderByMappingMap.put("roleTypeName", "roleType");
        NOTICE.orderByMappingMap.put("noticeTypeName", "noticeType");
    }

    /**
     * 映射关系
     */
    private final HashMap<String, String> orderByMappingMap;

    SystemOrderByMappingEnum(HashMap<String, String> orderByMappingMap) {
        this.orderByMappingMap = orderByMappingMap;
    }

    @Override
    public HashMap<String, String> apply() {
        return orderByMappingMap;
    }

}
