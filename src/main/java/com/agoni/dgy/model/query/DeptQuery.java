package com.agoni.dgy.model.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "Dept对象", description = "部门分页查询")
public class DeptQuery implements Serializable {
    
    @ApiModelProperty("公司名字")
    private String name;
    
    @ApiModelProperty("部门状态（0正常 1停用）")
    private String status;
    
}
