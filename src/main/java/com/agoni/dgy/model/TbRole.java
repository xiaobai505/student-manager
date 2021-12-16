package com.agoni.dgy.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * tb_class
 * @author 
 */
@Data
public class TbRole implements Serializable {
    /**
     * id主键
     */
    private Integer id;

    /**
     * 班级名称
     */
    private String className;

    /**
     * 班级code
     */
    private String classCode;

    /**
     * 创建时间
     */
    private Date createTime;

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
    private Date updateTime;

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

    private static final long serialVersionUID = 1L;
}