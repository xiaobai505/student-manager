package com.agoni.system.model.query;

import lombok.Data;

@Data
public class RolePageQuery extends BasePageQuery {
    
    private String roleNameEq;
    
    private String roleCodeEq;

    private Integer statusEq;
}
