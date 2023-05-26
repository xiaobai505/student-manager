package com.agoni.system.model.bo;

import com.agoni.dgy.model.po.Major;
import com.agoni.system.model.po.Role;
import com.agoni.system.model.po.User;
import lombok.Data;

/**
 * @author gyd
 */
@Data
public class AddUserFrom {

    private User user;

    private Role role;

    private Major major;
}
