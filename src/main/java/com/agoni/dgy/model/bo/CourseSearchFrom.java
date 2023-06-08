package com.agoni.dgy.model.bo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Builder;
import lombok.Data;

/**
 * @author gyd
 */
@Data
@Builder
public class CourseSearchFrom extends Page {

    private String courseName;
    
    private String teacher;
    
    private Boolean isMust;
    
}
