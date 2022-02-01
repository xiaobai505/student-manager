package com.agoni.dgy.model.po;

import com.baomidou.mybatisplus.annotation.*;
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
 * 班级表
 * </p>
 *
 * @author dgy
 * @since 2022-01-04
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_major")
@ApiModel(value = "Major对象", description = "班级表")
public class Major extends AbstractEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("学校分院")
    @TableField("School")
    private String school;

    @ApiModelProperty("专业")
    @TableField("major")
    private String major;

    @ApiModelProperty("班级code")
    @TableField("major_code")
    private String majorCode;

}
