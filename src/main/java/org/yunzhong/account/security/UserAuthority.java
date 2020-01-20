package org.yunzhong.account.security;

import org.springframework.security.core.GrantedAuthority;
import org.yunzhong.account.accounting.model.SysPermission;

import lombok.Data;

@Data
public class UserAuthority implements GrantedAuthority {
    private static final long serialVersionUID = -2346209438687483717L;

    private SysPermission permission;

    public UserAuthority(SysPermission permission) {
        this.permission = permission;
    }

    @Override
    public String getAuthority() {
        return permission.getPermissionSign();
    }

}
