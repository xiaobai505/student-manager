package com.agoni.dgy.model.bo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class CourseSearchFrom extends Page {
    
    private String courseName;
    
    private String teacher;
    
}
