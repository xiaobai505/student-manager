package com.agoni.dgy.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * 用户与岗位关联表
 * @TableName sys_user_post
 */
@TableName(value ="sys_user_post")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "UserPost对象", description = "用户与岗位关联表")
public class UserPost implements Serializable {
    
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty("用户角色关系")
    @TableId("id")
    private Long id;
    
    @ApiModelProperty("用户ID")
    private Long userId;
    
    @ApiModelProperty("岗位ID")
    private Long postId;


    
}