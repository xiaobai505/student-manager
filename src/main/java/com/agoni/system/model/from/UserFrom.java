package com.agoni.system.model.from;

import com.agoni.system.model.po.Dept;
import com.agoni.system.model.po.Role;
import com.agoni.system.model.po.User;
import lombok.Data;

/**
 * @author gyd
 */
@Data
public class UserFrom extends User {


    private Role role;

    private Dept dept;
}
