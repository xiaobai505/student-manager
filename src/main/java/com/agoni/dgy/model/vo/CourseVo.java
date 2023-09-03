package com.agoni.dgy.model.vo;

import com.agoni.dgy.model.po.Course;
import com.agoni.dgy.model.po.Result;
import com.diboot.core.binding.annotation.BindCount;
import com.diboot.core.binding.annotation.BindDict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "DictConfig对象", description = "字典配置表")
public class CourseVo extends Course {
    
    @ApiModelProperty("是否必修")
    @BindDict(type = "isMust",field = "isMust")
    private String isMustDisplay;

    @BindCount(entity = Result.class, condition = "this.id=course_id and del_flag=0")
    private Integer count;

}
