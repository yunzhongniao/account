package org.yunzhong.account.accounting.api;

import lombok.Data;

@Data
public class AcctRequestHead {
    private String accountBookId;
    private String appId;
    private String userName;
    private String password;
    private String version;
    private String sign;
}
