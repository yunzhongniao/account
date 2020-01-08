package org.yunzhong.account.accounting.api;

public class AcctResponseBuilder {

    public static AcctResponse create(Object result) {
        return new AcctResponse(result);
    }
}
