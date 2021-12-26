package com.agoni.dgy.model.from;

import com.agoni.dgy.model.po.Role;
import com.agoni.dgy.model.po.User;
import lombok.Data;

@Data
public class UserAndRoleFrom {

    private User user;

    private Role role;
}
