package com.agoni.system.model.bo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class RoleSearchFrom extends Page {
    
    private String name;
    
    private String roles;
}
