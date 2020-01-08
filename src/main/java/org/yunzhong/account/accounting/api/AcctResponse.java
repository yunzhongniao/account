package org.yunzhong.account.accounting.api;

import lombok.Data;

@Data
public class AcctResponse {
    private String code;
    private String message;
    private Object data;

    public AcctResponse(Object result) {
        this("200", null, result);
    }

    public AcctResponse(String code, String message, Object result) {
        this.code = code;
        this.message = message;
        this.data = result;
    }

}
