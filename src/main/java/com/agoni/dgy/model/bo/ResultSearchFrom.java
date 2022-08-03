package com.agoni.dgy.model.bo;

import com.agoni.dgy.model.po.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.diboot.core.binding.query.BindQuery;
import com.diboot.core.binding.query.Comparison;
import lombok.Data;

@Data
public class ResultSearchFrom extends Page {
    
    @BindQuery(comparison = Comparison.EQ, entity= User.class, field="name", condition="this.user_id=id")
    private String studentName;
    
    private String className;
    
}
