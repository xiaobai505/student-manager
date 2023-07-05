package com.agoni.system.model.vo;

import com.agoni.system.model.po.Dept;
import com.agoni.system.model.po.Role;
import com.agoni.system.model.po.User;
import com.diboot.core.binding.annotation.BindField;
import com.diboot.core.binding.annotation.BindFieldList;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "UserVo对象", description = "用户信息")
public class UserVo extends User {
    
    @BindField(entity = Dept.class,field = "name",condition = "this.dept_id=id")
    private String deptName;

    @BindFieldList(entity = Role.class, field = "roleName",
            condition = "this.id=sys_role_user.user_id AND sys_role_user.role_id=id", splitBy = ",")
    private String roles;
}
