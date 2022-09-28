package com.agoni.dgy.model.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class ResultQuery extends Page {
    
    private String courseName;
}
