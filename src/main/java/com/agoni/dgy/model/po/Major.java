package com.agoni.dgy.model.po;

import com.agoni.dgy.model.enums.majorEnum;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * <p>
 * 班级表
 * </p>
 *
 * @author dgy
 * @since 2022-01-04
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_major")
@ApiModel(value = "Major对象", description = "班级表")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Major extends AbstractEntity  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty("学校分院")
    @TableField("School")
    private String school;

    @ApiModelProperty("专业")
    @TableField("major")
    private String major;

    @ApiModelProperty("班级code")
    @TableField("major_code")
    private majorEnum majorCode;
}
