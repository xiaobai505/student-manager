package com.agoni.dgy.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 分校部门表
 *
 * @TableName tb_dept
 */
@TableName(value = "tb_dept")
@Data
public class Dept extends AbstractEntity {
    
    /**
     * 公司名字
     */
    private String name;
    
    /**
     * 1 公司 2 分公司 3 部门
     */
    private Integer type;
    
    /**
     *
     */
    private Integer parentid;
    
    /**
     *
     */
    private String sort;
    
    /**
     *
     */
    private Integer leaderuserid;
    
    /**
     *
     */
    private String phone;
    
    /**
     *
     */
    private String email;
    
    /**
     * 状态
     */
    private Integer status;
    
    /**
     * remark
     */
    private String remark;
    
}