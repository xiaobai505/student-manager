package com.agoni.dgy.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "User对象", description = "用户表")
public class UserAndRole implements Serializable {


    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("真实姓名")
    private String name;

    @ApiModelProperty("性别，1男，2女")
    private String sex;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码，加密存储")
    private String password;

    @ApiModelProperty("角色编码")
    private String roleCode;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("注册手机号")
    private String phone;

    @ApiModelProperty("手机是否验证 （0否  1是）")
    private String isMobileCheck;

    @ApiModelProperty("注册邮箱")
    private String email;

    @ApiModelProperty("邮箱是否检测（0否  1是）")
    private String isEmailCheck;

    @ApiModelProperty("QQ号码")
    private String qq;

    @ApiModelProperty("头像地址")
    private String headPic;

    @ApiModelProperty("账户余额")
    private BigDecimal accountBalance;

    @ApiModelProperty("会员等级")
    private Integer userLevel;

    @ApiModelProperty("积分")
    private Integer points;

    @ApiModelProperty("经验值")
    private Integer experienceValue;

    @ApiModelProperty("生日")
    private LocalDateTime birthday;

    @ApiModelProperty("最后登录时间")
    private LocalDateTime lastLoginTime;

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
}
