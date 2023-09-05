package com.agoni.system.model.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "pwdQuery对象", description = "重置密码")
public class PwdQuery implements Serializable {

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("旧密码")
    private String oldPassword;

    @ApiModelProperty("新密码")
    @Builder.Default
    private String newPassword = "admin123";
    
    @ApiModelProperty("确认密码")
    private String confirmPassword= "admin123";
}
