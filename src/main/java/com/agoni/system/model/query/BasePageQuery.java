package com.agoni.system.model.query;

import com.baomidou.mybatisplus.core.toolkit.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * 分页查询基础类
 *
 * @author t-guoyu.dong@pcitc.com
 * @since 2023/6/30
 */
@Data
@SuperBuilder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "PageQuery", description = "分页查询")
public class BasePageQuery {

    /**
     * 页码
     */
    @Schema(description = "页码")
    @Builder.Default
    private Integer currentPage = 1;

    /**
     * 每页显示条数
     */
    @Schema(description = "每页显示条数")
    @Builder.Default
    private Integer pageSize = 10;

    /**
     * 排序字段，默认id，如果要修改排序字段，需要改成对应的属性名，不是字段名！！！
     */
    @Schema(description = "排序字段，默认id")
    @Builder.Default
    private String orderBy = "create_time";

    /**
     * 排序方式，默认倒序，正序则改为ASC
     */
    @Schema(description = "排序方式，默认倒序")
    @Builder.Default
    private String order = Constants.ASC;
}