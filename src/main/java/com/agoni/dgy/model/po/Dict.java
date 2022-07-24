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
 * @TableName tb_dict
 */
@TableName(value = "tb_dict")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Dict对象", description = "字典表")
public class Dict extends AbstractEntity {
    
    @ApiModelProperty("父id")
    @TableField("parentId")
    private Integer parentId;
    /**
     * 字典名字(大类)
     */
    private String name;
    
    /**
     * 字典类型
     */
    private String model;
    
    /**
     * 备注
     */
    private String remark;
}