package edu.java.deipss.service.test.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统内部异常
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppInnerException extends RuntimeException {

    /**
     * 错误码
     */
    private String code;
    /**
     * 对外部的提示信息
     */
    private String hint;
    /**
     * 系统内部的信息
     */
    private String message;
}
