package com.agoni.core.exception;

import com.agoni.system.model.response.ResponseEntity;
import com.agoni.system.utils.HttpUitl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

import static com.agoni.core.exception.enums.httpEnum.FORBIDDEN;
import static com.agoni.core.exception.enums.httpEnum.INNER_ERROR;


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
        logError(e, false);
        return ResponseEntity.body(INNER_ERROR);
    }

    /**
     * 处理空指针的异常
     */
    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseEntity exceptionHandler(AccessDeniedException e) {
        logError(e, true);
        return ResponseEntity.body(FORBIDDEN);
    }

    /**
     * 处理空指针的异常
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity exceptionHandler(NullPointerException e) {
        logError(e, true);
        return ResponseEntity.body(INNER_ERROR);
    }

    /**
     * 未知异常
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity systemExceptionHandler(Exception e) {
        logError(e, true);
        return ResponseEntity.body(INNER_ERROR);
    }

    /**
     * 自定义校验异常（如参数校验等）
     */
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity businessExceptionHandler(BusinessException e) {
        logError(e, false);
        return ResponseEntity.body(e.getErrorCode(), e.getMessage());
    }

    /**
     * http请求方式不支持
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity handleException(HttpRequestMethodNotSupportedException e) {
        logError(e, true);
        return ResponseEntity.body(INNER_ERROR);
    }

    protected void logError(Exception e, boolean printStackTrace) {
        HttpServletRequest req = HttpUitl.getRequest();
        String pattern = "%s,Class {%s}Host {%s}Invokes url {%s} ";
        String host = req.getRemoteHost();
        String url = req.getRequestURL().toString();
        String message = String.format(pattern, e.getMessage(), e.getClass().getName(), host, url);
        log.error(message);
        if (printStackTrace) {
            log.error("-" + e.getMessage(), e);
        }
    }
}
