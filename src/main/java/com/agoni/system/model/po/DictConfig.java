package com.agoni.system.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 字典详细表
 * @TableName sys_dict_config
 */
@TableName(value ="sys_dict_config")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "DictConfig对象", description = "字典配置表")
public class DictConfig extends AbstractEntity {
    /**
     * 数据字典目录Id
     */
    private Long dictId;

    /**
     * 排序字段（用户可以手动操作数据顺序时用到）
     */
    private Integer orderNum;

    /**
     * 字典显示
     */
    private String dictDisplay;

    /**
     * 字典实际值
     */
    private String dictValue;

    /**
     * 备注
     */
    private String remark;
}