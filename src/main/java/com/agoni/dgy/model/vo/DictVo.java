package com.agoni.dgy.model.vo;

import com.agoni.dgy.model.po.Dict;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Dict对象", description = "字典表")
public class DictVo extends Dict {
    
    private List<DictVo> children;
}
