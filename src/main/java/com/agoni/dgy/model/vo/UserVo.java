package com.agoni.dgy.model.vo;

import com.agoni.dgy.model.po.Dept;
import com.agoni.dgy.model.po.RoleUser;
import com.agoni.dgy.model.po.User;
import com.diboot.core.binding.annotation.BindField;
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
@ApiModel(value = "UserVo对象", description = "用户信息")
public class UserVo extends User {
    
    @BindField(entity = Dept.class,field = "name",condition = "this.dept_id=id")
    private String deptName;
    
    
    @BindField(entity = RoleUser.class, field = "roleName", condition = "this.id=user_id")
    private List<String> roles;
}
