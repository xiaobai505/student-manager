package com.agoni.dgy.model.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_user")
@ApiModel(value = "User对象", description = "用户表")
public class User extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("昵称")
    @TableField("nick_name")
    private String nickName;

    @ApiModelProperty("真实姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("性别，1男，2女")
    @TableField("sex")
    private String sex;

    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty("密码，加密存储")
    @TableField("password")
    private String password;

    @ApiModelProperty("注册手机号")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("手机是否验证 （0否  1是）")
    @TableField("is_mobile_check")
    private String isMobileCheck;

    @ApiModelProperty("注册邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("邮箱是否检测（0否  1是）")
    @TableField("is_email_check")
    private String isEmailCheck;

    @ApiModelProperty("QQ号码")
    @TableField("qq")
    private String qq;

    @ApiModelProperty("头像地址")
    @TableField("head_pic")
    private String headPic;

    @ApiModelProperty("账户余额")
    @TableField("account_balance")
    private BigDecimal accountBalance;

    @ApiModelProperty("会员等级")
    @TableField("user_level")
    private Integer userLevel;

    @ApiModelProperty("积分")
    @TableField("points")
    private Integer points;

    @ApiModelProperty("经验值")
    @TableField("experience_value")
    private Integer experienceValue;

    @ApiModelProperty("生日")
    @TableField("birthday")
    private LocalDateTime birthday;

    @ApiModelProperty("最后登录时间")
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;
}
