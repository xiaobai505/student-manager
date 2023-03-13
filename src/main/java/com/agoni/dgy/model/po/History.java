package com.agoni.dgy.model.po;

import com.agoni.system.Interceptor.Fastjson2TypeHandler;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@TableName(value = "tb_history", autoResultMap = true)
@ApiModel(value = "History对象", description = "历史记录表", parent = AbstractEntity.class)
public class History extends AbstractEntity<AbstractEntity> {

    private static final long serialVersionUID = 1L;
    
    @TableField(value = "log_data",typeHandler = Fastjson2TypeHandler.class)
    private JSON logData;

    @TableField("log_type")
    private String logType;

    @TableField("course_id")
    private Integer courseId;

}
