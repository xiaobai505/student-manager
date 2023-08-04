package com.agoni.system.response;

import com.agoni.system.config.enums.ResponseCodeEnum;
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
public class ResponseEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer code;
    private String msg;
    private T data;
    private boolean success = true;


    private ResponseEntity(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> ResponseEntity<T> body(T data) {
        return new ResponseEntity(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data,true);
    }

    public static <T> ResponseEntity<T> body(ResponseCodeEnum responseCodeEnum) {
        return new ResponseEntity(responseCodeEnum.getCode(), responseCodeEnum.getmsg());
    }

    public static <T> ResponseEntity<T> body(ResponseCodeEnum responseCodeEnum, T data) {
        return new ResponseEntity(responseCodeEnum.getCode(), responseCodeEnum.getmsg(), data,true);
    }

}
