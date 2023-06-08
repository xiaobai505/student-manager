package com.agoni.dgy.model.bo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * @author gyd
 */
@Data
public class MajorSearchFrom extends Page {
    
    private String school;
    
    private String major;
    
}
