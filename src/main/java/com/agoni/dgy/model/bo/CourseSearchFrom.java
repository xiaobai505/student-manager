package com.agoni.dgy.model.bo;

import com.agoni.system.model.query.BasePageQuery;
import lombok.Data;

/**
 * @author gyd
 */
@Data
public class CourseSearchFrom extends BasePageQuery {

    private String courseNameLike;

    private String teacherLike;

    private Boolean isMustEq;
}
