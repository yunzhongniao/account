package org.yunzhong.account.admin.model;

public class AuthRolePerm extends AcctBasicEntity {
    
    private int roleID;
    
    private int permID;
    
    private String permName;

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public int getPermID() {
        return permID;
    }

    public void setPermID(int permID) {
        this.permID = permID;
    }

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }
    
}
