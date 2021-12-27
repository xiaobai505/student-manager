package com.agoni.dgy.model.from;


import com.agoni.dgy.model.vo.UserAndRole;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;


@Data
public class FromPage implements Serializable {

    private Page page;

    private UserAndRole userAndRole;

}