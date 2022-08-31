package com.agoni.dgy.model.vo;

import com.agoni.dgy.model.po.Dept;
import com.agoni.dgy.model.po.User;
import com.diboot.core.binding.annotation.BindField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "DeptVo对象", description = "部门表返回对象")
public class DeptVo extends Dept {
    
    @ApiModelProperty("部门负责人")
    @BindField(entity= User.class, field="name", condition="this.leaderuserid=id")
    private String leader;
}
