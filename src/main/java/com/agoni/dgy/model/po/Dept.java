package com.agoni.dgy.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分校部门表
 *
 * @TableName tb_dept
 */
@TableName(value = "tb_dept")
@Data
public class Dept extends AbstractEntity {
    
    @ApiModelProperty("公司名字")
    private String name;
    
    @ApiModelProperty("类型")
    private Integer type;
    
    @ApiModelProperty("父id")
    @TableField("parentId")
    private Integer parentId;
    
    @ApiModelProperty("排序字段")
    private String sort;
    
    @ApiModelProperty("1 公司 2 分公司 3 部门")
    private Integer leaderuserid;
    
    @ApiModelProperty("联系方式")
    private String phone;
    
    @ApiModelProperty("邮箱")
    private String email;
    
    @ApiModelProperty("状态")
    private Integer status;
    
    @ApiModelProperty("理由")
    private String remark;
    
}