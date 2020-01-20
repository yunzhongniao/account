package org.yunzhong.account.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.yunzhong.account.accounting.dao.SysPermissionMapper;
import org.yunzhong.account.accounting.dao.SysUserMapper;
import org.yunzhong.account.accounting.model.SysPermission;
import org.yunzhong.account.accounting.model.SysUser;

@Service
public class AccountUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserMapper.selectByUsername(username);
        if (sysUser != null) {
            List<SysPermission> permissions = sysPermissionMapper.selectByUser(sysUser.getId());
            User user = new User(sysUser, permissions);
            return user;
        }
        return null;
    }

}
