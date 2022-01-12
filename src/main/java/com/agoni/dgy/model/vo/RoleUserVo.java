package com.agoni.dgy.model.vo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户角色关系表
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "RoleUser对象", description = "用户角色关系表")
public class RoleUserVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户角色关系")
    private Long id;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("角色ID")
    private Long roleId;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("创建人标识")
    private String createBy;

    @ApiModelProperty("创建人姓名")
    private String createByName;

    @ApiModelProperty("最后修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("最后修改人标识")
    private String updateBy;

    @ApiModelProperty("最后修改人姓名")
    private String updateByName;

    @ApiModelProperty("删除标记（0：正常，1：删除）")
    @TableLogic
    private Integer delFlag;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色编码")
    private String roleCode;

    @ApiModelProperty("角色类型")
    private String roleType;


}
