package org.yunzhong.account.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.yunzhong.account.admin.model.AuthRolePerm;

public class AuthRolePermDao extends AcctBasicDao<AuthRolePerm> {
    
    public static class AuthRolePermRowMapper implements RowMapper<AuthRolePerm> {

        @Override
        public AuthRolePerm mapRow(ResultSet rs, int rowNum) throws SQLException {
            AuthRolePerm rolePerm = new AuthRolePerm();
            rolePerm.setRoleID(rs.getInt("ROLEID"));
            rolePerm.setPermName(rs.getString("PERMNAME"));
            rolePerm.setPermID(rs.getInt("PERMID"));
            return rolePerm;
        }

    }

    public List<AuthRolePerm> getAll() {
        return this.querySQL("SELECT auroleperm.ROLEID,auroleperm.PERMID,auperm.PERMNAME from auroleperm,auperm where auroleperm.PERMID=auperm.PERMID ORDER BY ROLEID", new AuthRolePermRowMapper());
    }
    
    public List<AuthRolePerm> getByRoleId(int roleID) {
        return this.querySQL("SELECT auroleperm.ROLEID,auroleperm.PERMID,auperm.PERMNAME from auroleperm,auperm where auroleperm.PERMID=auperm.PERMID and auroleperm.ROLEID=? ORDER BY ROLEID", new AuthRolePermRowMapper(), roleID);
    }

    public int add(AuthRolePerm rolePerm) {
        String sql = "INSERT INTO auroleperm(ROLEID,PERMID) VALUES(?,?)";
        return this.updateSQL(sql, rolePerm.getRoleID(), rolePerm.getPermID());
    }

    public int delete(int roleID) {
        String sql = "DELETE FROM auroleperm where ROLEID = ?";
        return this.updateSQL(sql, roleID);
    }

    public Long countPerm(int permID){
        String sql =  "SELECT COUNT(1) FROM auroleperm WHERE PERMID = ? ";
        return this.queryObject(sql, Long.class, permID);
    }
}
