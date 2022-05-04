package com.agoni.dgy.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 累计学分表
 * @TableName tb_graduate
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_graduate",autoResultMap = true)
@ApiModel(value = "graduate对象", description = "")
public class Graduate extends AbstractEntity implements Serializable {
    
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 必修课总分
     */
    private Integer mustScore;

    /**
     * 选修课分数
     */
    private Integer selectScore;

    /**
     * 毕业设计
     */
    private String graduate;
    
}