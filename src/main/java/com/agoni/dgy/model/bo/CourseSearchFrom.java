package com.agoni.dgy.model.bo;

import com.agoni.system.model.bo.PageBaseQuery;
import lombok.Data;

/**
 * @author gyd
 */
@Data
public class CourseSearchFrom extends PageBaseQuery {

    private String courseNameLike;

    private String teacherLike;

    private Boolean isMustEq;
}
