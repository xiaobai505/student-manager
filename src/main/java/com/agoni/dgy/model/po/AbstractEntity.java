package com.agoni.dgy.model.po;


import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractEntity implements Serializable {
    
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty("id主键")
    @TableId(value = "id", type = IdType.AUTO)
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;
    
    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;

    @ApiModelProperty("创建人标识")
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;

    @ApiModelProperty("创建人姓名")
    @TableField(value = "create_by_name", fill = FieldFill.INSERT)
    private String createByName;

    @ApiModelProperty("最后修改时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateTime;

    @ApiModelProperty("最后修改人标识")
    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private String updateBy;

    @ApiModelProperty("最后修改人姓名")
    @TableField(value = "update_by_name", fill = FieldFill.UPDATE)
    private String updateByName;

    @ApiModelProperty("删除标记（0：正常，1：删除）")
    @TableField("del_flag")
    @TableLogic
    private Integer delFlag;
}
