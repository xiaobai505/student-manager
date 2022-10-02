package com.agoni.dgy.model.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value = "MenuQuery对象", description = "菜单查询条件")
public class LogininforQuery extends Page {
    
    @ApiModelProperty("用户账号")
    private String userName;
}
