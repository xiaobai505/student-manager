package com.agoni.core.omp.config.enums;

import lombok.Getter;

/**
 * @author gyd
 */

@Getter
public enum Operator {
    EQ("Eq"),
    NE("Ne"),
    LT("Lt"),
    GT("Gt"),
    GE("Ge"),
    LE("Le"),
    LIKE("Like"),
    LIKE_LEFT("LikeLeft"),
    LIKE_RIGHT("LikeRight"),
    NOT_LIKE("NotLike"),
    IN("In"),
    NOT_IN("NotIn"),
    IS_NULL("IsNull"),
    IS_NOT_NULL("IsNotNull");

    private final String value;

    Operator(final String value) {
        this.value = value;
    }
}
