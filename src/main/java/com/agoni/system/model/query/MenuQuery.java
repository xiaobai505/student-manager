package com.agoni.system.model.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@ApiModel(value = "MenuQuery对象", description = "菜单查询条件")
public class MenuQuery {
    
    @ApiModelProperty("角色CODE")
    private String code;

    @ApiModelProperty("角色CODE")
    private List<String> codeIn;
    
    @ApiModelProperty("角色ID")
    private Long roleId;
}
