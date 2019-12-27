package org.yunzhong.account.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = -6974873226640312872L;

    private String code;
    private String message;

    public ServiceException(String msg) {
        this.message = msg;
    }

    public ServiceException(String code, String msg) {
        this.code = code;
        this.message = msg;
    }
}
