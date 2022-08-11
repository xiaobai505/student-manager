package com.agoni.dgy.model.bo;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class MenuFrom {
    
    private String code;
    
    private Long roleId;
}
