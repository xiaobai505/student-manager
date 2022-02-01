package com.agoni.dgy.model.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_history")
@ApiModel(value = "History对象", description = "History对象")
public class History extends AbstractEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "log_id", type = IdType.AUTO)
    private Integer logId;

    @TableField("log_data")
    private String logData;

    @TableField("log_type")
    private String logType;

    @TableField("course_id")
    private Integer courseId;

}
