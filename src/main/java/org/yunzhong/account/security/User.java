package org.yunzhong.account.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;
import org.yunzhong.account.accounting.model.SysPermission;
import org.yunzhong.account.accounting.model.SysUser;

import lombok.Data;

@Data
public class User implements UserDetails {
    private static final long serialVersionUID = -534343702362536690L;
    private SysUser sysUser;
    private List<SysPermission> permissions;

    public User(SysUser sysUser, List<SysPermission> permissions) {
        this.sysUser = sysUser;
        this.permissions = permissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (CollectionUtils.isEmpty(permissions)) {
            return null;
        }
        List<UserAuthority> authories = new ArrayList<>();
        for (SysPermission permission : permissions) {
            authories.add(new UserAuthority(permission));
        }
        return authories;
    }

    @Override
    public String getPassword() {
        return sysUser.getPassword();
    }

    @Override
    public String getUsername() {
        return sysUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return sysUser.getLockSign() >= 0;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return sysUser.getEnableSign() >= 0;
    }

}
