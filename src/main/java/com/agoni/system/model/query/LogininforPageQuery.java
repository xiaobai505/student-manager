package com.agoni.system.model.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author gyd
 */
@Data
@ApiModel(value = "MenuQuery对象", description = "菜单查询条件")
public class LogininforPageQuery extends BasePageQuery {

    @ApiModelProperty("用户账号")
    private String userNameEq;

    @ApiModelProperty("状态")
    private Integer statusEq;
    
}
