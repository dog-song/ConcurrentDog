package com.dogsong.common;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * NoticeHandlerException
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/7/12
 */
@Getter
public class NoticeHandlerException extends RuntimeException implements Serializable {

    private int code;

    private Object data;

    private String message = StringUtils.EMPTY;
    
    public static final long serialVersionUID = 1L;

    public NoticeHandlerException() {
        super();
    }

    public NoticeHandlerException(String msg) {
        super();
        this.message = msg;
    }
    public NoticeHandlerException(int code) {
        super();
        this.code = code;
    }

    public NoticeHandlerException(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public NoticeHandlerException(int code, Object errorInfo) {
        super();
        this.code = code;
        this.data = errorInfo;
    }

    public NoticeHandlerException(int code, String message, Object errorInfo){
        this(code,message);
        this.data = errorInfo;
    }

    public NoticeHandlerException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public NoticeHandlerException(String msg, Exception cause) {
        super(cause);
        this.message = msg;
    }
}
