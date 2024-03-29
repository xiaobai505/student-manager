package com.agoni.dgy.model.vo;

import com.agoni.dgy.model.po.Result;
import com.agoni.system.model.po.User;
import com.diboot.core.binding.annotation.BindField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ResultVo extends Result {
    
    @ApiModelProperty("学生姓名")
    @BindField(entity= User.class, field="name", condition="this.user_id=id")
    private String studentName;
    
    
    @ApiModelProperty("昵称")
    @BindField(entity= User.class, field="nickName", condition="this.user_id=id")
    private String nickName;
}
