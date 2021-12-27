package com.agoni.dgy.model.from;

import com.agoni.dgy.model.po.Major;
import com.agoni.dgy.model.po.Role;
import com.agoni.dgy.model.po.User;
import lombok.Data;

@Data
public class AddUserFrom {

    private User user;

    private Role role;

    private Major major;
}
