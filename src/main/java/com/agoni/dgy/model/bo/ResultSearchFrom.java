package com.agoni.dgy.model.bo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class ResultSearchFrom extends Page {
    
    private String studentName;
    
    private String className;
    
}
