package edu.java.deipss.service.test.exception;

/**
 * 业务异常
 */
public class BizException extends RuntimeException {
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
