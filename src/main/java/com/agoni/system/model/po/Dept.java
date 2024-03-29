package com.agoni.system.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 分校部门表
 *
 * @TableName sys_dept
 */
@TableName(value = "sys_dept")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Dept对象", description = "部门表")
public class Dept extends AbstractEntity {
    
    @ApiModelProperty("公司名字")
    private String name;
    
    @ApiModelProperty("祖级列表")
    private String ancestors;
    
    @ApiModelProperty("父id")
    @TableField("parentId")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long parentId;
    
    @ApiModelProperty("排序字段")
    private Integer sort;
    
    @ApiModelProperty("1 公司 2 分公司 3 部门")
    private Integer leaderuserid;
    
    @ApiModelProperty("联系方式")
    private String phone;
    
    @ApiModelProperty("邮箱")
    private String email;
    
    @ApiModelProperty("部门状态（0正常 1停用）")
    private Integer status;
    
    @ApiModelProperty("理由")
    private String remark;
    
}