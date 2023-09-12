package com.agoni.dgy.model.query;

import com.agoni.system.model.query.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ResultQuery对象", description = "结果查询条件")
public class ResultPageQuery extends BasePageQuery {

    @ApiModelProperty("课程名字")
    private String courseNameLike;

    @ApiModelProperty("课程名字")
    private Long userIdEq;

    @ApiModelProperty("课程id")
    private Long courseIdEq;
}
