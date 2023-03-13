package com.agoni.dgy.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @TableName sys_dict
 */
@TableName(value = "sys_dict")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Dict对象", description = "字典表")
public class Dict extends AbstractEntity<Dict> {
    
    @ApiModelProperty("父id")
    @TableField("parentId")
    private Long parentId;
    
    @ApiModelProperty("字典名字(大类)")
    private String name;
    
    @ApiModelProperty("字典类型")
    private String model;
    
    @ApiModelProperty("备注")
    private String remark;
}