package com.agoni.system.model.vo;

import com.agoni.system.model.po.Dict;
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
@ApiModel(value = "DictVo对象", description = "字典表")
public class DictVo extends Dict {
    
    private List<DictVo> children;
}
