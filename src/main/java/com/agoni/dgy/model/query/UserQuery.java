package com.agoni.dgy.model.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserQuery extends Page {

    private String name;
    
    private String roles;
    
    private Long deptId;
    
}
