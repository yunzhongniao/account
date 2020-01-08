package org.yunzhong.account.accounting.api;

import lombok.Data;

@Data
public class AcctRequest<T extends AcctBasicRequestBody> {
    private AcctRequestHead head;
    private T body;
}
