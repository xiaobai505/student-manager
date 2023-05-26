package com.agoni.dgy.config.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum majorEnum {
    
    PRIMARY(2101, "网络技术21"),
    SECONDORY(2, "中学"),
    HIGH(2102, "哲学");
    
    @EnumValue//标记数据库存的值是code
    private final int majorCode;
    private final String descp;

    
    majorEnum(int majorCode, String descp) {
        this.majorCode = majorCode;
        this.descp = descp;
    }
    
    @JsonCreator
    public static majorEnum getByCode(@JsonProperty("majorCode") int majorCode) {
        return Arrays.stream(majorEnum.values()).filter(item -> item.majorCode == majorCode).findFirst().get();
    }

}
