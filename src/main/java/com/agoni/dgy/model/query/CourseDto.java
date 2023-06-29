package com.agoni.dgy.model.query;

import com.agoni.system.model.po.User;
import com.diboot.core.binding.query.BindQuery;
import com.diboot.core.binding.query.Comparison;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 测试多表查询
 *
 * @author t-guoyu.dong@pcitc.com
 * @since 2023/6/8
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    // join其他表（查询条件绑定字段）
    @BindQuery(comparison = Comparison.EQ, entity = User.class, column = "userName",condition = "this.user_id=id")
    private String userName;
}