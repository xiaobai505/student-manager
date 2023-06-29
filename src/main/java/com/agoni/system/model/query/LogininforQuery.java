package com.agoni.system.model.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author gyd
 */
@Data
@SuperBuilder
@ApiModel(value = "MenuQuery对象", description = "菜单查询条件")
public class LogininforQuery extends baseQuery {

    @ApiModelProperty("用户账号")
    private String userNameEq;
    
}
