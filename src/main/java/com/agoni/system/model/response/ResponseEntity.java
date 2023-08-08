package com.agoni.system.model.response;

import com.agoni.core.exception.enums.httpEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author gyd
 */
@Data
public class ResponseEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer code;
    private String msg;
    private T data;
    private boolean success;

    public static <T> ResponseEntity<T> body(T data) {
        ResponseEntity<T> result = new ResponseEntity<>();
        result.setData(data);
        result.setSuccess(Boolean.TRUE);
        return result;
    }

    public static <T> ResponseEntity<T> body(httpEnum codeEnum) {
        ResponseEntity<T> result = new ResponseEntity<>();
        result.setCode(codeEnum.getCode());
        result.setMsg(codeEnum.getMsg());
        result.setSuccess(Boolean.TRUE);
        return result;
    }

    public static <T> ResponseEntity<T> fail(httpEnum codeEnum) {
        ResponseEntity<T> result = new ResponseEntity<>();
        result.setCode(codeEnum.getCode());
        result.setMsg(codeEnum.getMsg());
        result.setSuccess(Boolean.FALSE);
        return result;
    }

}
