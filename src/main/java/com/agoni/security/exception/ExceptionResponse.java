package com.agoni.security.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author gyd
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse<T> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String msg;
    
    private T data;
    
    private ExceptionResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    public static <T> ExceptionResponse<T> body(T data) {
        ExceptionResponse<T> ExceptionResponse = new ExceptionResponse(HttpStatus.OK.value(),
                HttpStatus.OK.getReasonPhrase(), data);
        return ExceptionResponse;
    }
    
    public static <T> ExceptionResponse<T> body(ExceptionEnum exceptionEnum) {
        ExceptionResponse<T> ExceptionResponse = new ExceptionResponse(exceptionEnum.getCode(), exceptionEnum.getmsg());
        return ExceptionResponse;
    }
    
    public static <T> ExceptionResponse<T> body(ExceptionEnum exceptionEnum, T data) {
        ExceptionResponse<T> ExceptionResponse = new ExceptionResponse(exceptionEnum.getCode(),
                exceptionEnum.getmsg(), data);
        return ExceptionResponse;
    }
    
}
