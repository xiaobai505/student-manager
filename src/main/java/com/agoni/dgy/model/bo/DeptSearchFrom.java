package com.agoni.dgy.model.bo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class DeptSearchFrom extends Page {
    
    private String name;
    
}
