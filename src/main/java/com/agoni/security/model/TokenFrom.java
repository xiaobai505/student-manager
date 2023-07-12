package com.agoni.security.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * TokenFrom
 *
 * @author t-guoyu.dong@pcitc.com
 * @since 2023/7/12
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Token对象", description = "Token对象")
public class TokenFrom {

    @ApiModelProperty("refreshToken")
    private String refreshToken;

}