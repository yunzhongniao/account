package org.yunzhong.account.admin.model;

import java.util.List;

public class AuthRole extends AcctBasicEntity {
    
    private int roleID;
    
    private String roleName;
    
    private List<AuthPerm> perms;

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<AuthPerm> getPerms() {
        return perms;
    }

    public void setPerms(List<AuthPerm> perms) {
        this.perms = perms;
    }
    
}
