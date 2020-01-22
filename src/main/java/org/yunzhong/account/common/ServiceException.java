package org.yunzhong.account.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = -6974873226640312872L;

    private String status;
    private String message;

    public static ServiceException create() {
        return new ServiceException("");
    }

    public ServiceException(String msg) {
        this.message = msg;
    }

    public ServiceException(String status, String msg) {
        this.status = status;
        this.message = msg;
    }
}
