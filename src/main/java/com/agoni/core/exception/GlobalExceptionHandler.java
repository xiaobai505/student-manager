package com.agoni.core.exception;

import com.agoni.system.response.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.agoni.system.config.enums.ResponseCodeEnum.INNER_ERROR;


/**
 * 一些常用的校验异常处理
 * @author gyd
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * validation参数校验异常
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidExceptionExceptionHandler(MethodArgumentNotValidException e) {
        StringBuilder errorMsg = new StringBuilder();
        e.getBindingResult().getFieldErrors().forEach(x -> errorMsg.append(x.getField()).append(x.getDefaultMessage()));
        log.info("validation parameters error！The reason is:{}", errorMsg);
        return ResponseEntity.body(INNER_ERROR);
    }

    /**
     * validation参数校验异常
     */
    @ExceptionHandler(value = BindException.class)
    public ResponseEntity bindException(BindException e) {
        StringBuilder errorMsg = new StringBuilder();
        e.getBindingResult().getFieldErrors().forEach(x -> errorMsg.append(x.getField()).append(x.getDefaultMessage()));
        log.info("validation parameters error！The reason is:{}", errorMsg);
        return ResponseEntity.body(INNER_ERROR);
    }

    /**
     * 处理空指针的异常
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity exceptionHandler(NullPointerException e) {
        log.error("null point exception！The reason is: ", e);
        return ResponseEntity.body(INNER_ERROR);
    }

    /**
     * 未知异常
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity systemExceptionHandler(Exception e) {
        log.error("system exception！The reason is：{}", e.getMessage(), e);
        return ResponseEntity.body(INNER_ERROR);
    }

    /**
     * 自定义校验异常（如参数校验等）
     */
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity businessExceptionHandler(BusinessException e) {
        log.info("business exception！The reason is：{}", e.getMessage(), e);
        return ResponseEntity.body(INNER_ERROR);
    }

    /**
     * http请求方式不支持
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity handleException(HttpRequestMethodNotSupportedException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.body(INNER_ERROR);
    }
}
