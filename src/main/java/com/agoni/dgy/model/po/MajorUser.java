package com.agoni.dgy.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 用户角色关系表
 * </p>
 *
 * @author dgy
 * @since 2021-12-27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_major_user")
@ApiModel(value = "MajorUser对象", description = "用户角色关系表")
public class MajorUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户角色关系")
    @TableId("id")
    private Long id;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Long userId;
    
    /**
     * 专业id
     */
    @ApiModelProperty("专业id")
    @TableField("major_id")
    private Long majorId;
    


}
