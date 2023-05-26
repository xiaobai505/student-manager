package com.agoni.core.omp;

import com.agoni.core.omp.config.enums.Operator;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface AutoWrapper {
    String name();

    Operator condition() default Operator.EQ;
}
