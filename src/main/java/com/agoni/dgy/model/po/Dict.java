package com.agoni.dgy.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName tb_dict
 */
@TableName(value = "tb_dict")
@Data
public class Dict implements Serializable {
    /**
     * 数据字典id
     */
    @TableId
    private Long id;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 创建人标识
     */
    private String createBy;
    
    /**
     * 创建人姓名
     */
    private String createByName;
    
    /**
     * 最后修改时间
     */
    private LocalDateTime updateTime;
    
    /**
     * 最后修改人标识
     */
    private String updateBy;
    
    /**
     * 最后修改人姓名
     */
    private String updateByName;
    
    /**
     * 删除标记（0：正常，1：删除）
     */
    private Integer delFlag;
    
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
    
    /**
     * 字典名字(大类)
     */
    private String name;
    
    /**
     * 字典类型
     */
    private String model;
    
    /**
     * 子类
     */
    private Object children;
    
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}