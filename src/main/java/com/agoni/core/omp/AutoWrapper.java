package com.agoni.core.omp;

import com.agoni.core.omp.enums.Operator;

import java.lang.annotation.*;

/**
 * @author gyd
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface AutoWrapper {
    String name();

    Operator condition() default Operator.EQ;
}
