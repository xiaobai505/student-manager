package com.agoni.security.model;

import cn.hutool.core.date.DateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * 返回前端的token对象
 *
 * @author t-guoyu.dong@pcitc.com
 * @since 2023/7/12
 */

@Data
@SuperBuilder
@ApiModel(value = "TokenVo对象", description = "TokenVo对象")
public class TokenVo {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("accessToken")
    private String accessToken;

    @ApiModelProperty("refreshToken")
    private String refreshToken;

    @ApiModelProperty("过期时间")
    private DateTime expires;
}