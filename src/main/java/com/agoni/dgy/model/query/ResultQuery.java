package com.agoni.dgy.model.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value = "ResultQuery对象", description = "结果查询条件")
public class ResultQuery extends Page {
    
    @ApiModelProperty("课程名字")
    private String courseName;
}
