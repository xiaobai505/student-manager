package com.agoni.system.model.query;

import lombok.Data;

@Data
public class RoleQuery extends PageBaseQuery {
    
    private String roleNameEq;
    
    private String roleCodeEq;

    private Integer statusEq;
}
