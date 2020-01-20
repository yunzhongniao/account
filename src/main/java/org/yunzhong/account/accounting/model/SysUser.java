package org.yunzhong.account.accounting.model;

import lombok.Data;

@Data
public class SysUser {
    private Long id;

    private String username;

    private String password;

    private String name;

    private Integer enableSign;

    private Integer lockSign;

}