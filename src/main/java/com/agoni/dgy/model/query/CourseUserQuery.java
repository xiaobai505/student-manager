package com.agoni.dgy.model.query;

import com.agoni.system.model.query.BasePageQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CourseUserQuery extends BasePageQuery {

    @ApiModelProperty("课程id")
    private Long courseIdEq;
}
