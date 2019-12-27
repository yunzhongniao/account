package org.yunzhong.account.admin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.yunzhong.account.admin.model.AuthPerm;
import org.yunzhong.account.admin.model.AuthRole;

public class AuthRoleDao extends AcctBasicDao<AuthRole> {

    public static class AuthRoleRowMapper implements RowMapper<AuthRole> {

        @Override
        public AuthRole mapRow(ResultSet rs, int rowNum) throws SQLException {
            AuthRole role = new AuthRole();
            role.setRoleID(rs.getInt("ROLEID"));
            role.setRoleName(rs.getString("ROLENAME"));
            return role;
        }

    }

    public List<AuthRole> getAll() {
        return this.querySQL("SELECT * FROM AUROLE ORDER BY ROLEID", new AuthRoleRowMapper());
    }

    public int update(AuthRole role) {
        String sql = "UPDATE AUROLE SET ROLENAME = ?  where  ROLEID = ? ";
        return this.updateSQL(sql, role.getRoleName(), role.getRoleID());
    }

    public int add(AuthRole role) {
        String sql = "INSERT INTO AUROLE(ROLENAME) VALUES(?)";
        return this.updateSQL(sql, role.getRoleName());
    }

    public int delete(int roleID) {
        String sql = "DELETE FROM AUROLE where ROLEID = ?";
        return this.updateSQL(sql, roleID);
    }

    public void appendPerm(int roleID, List<AuthPerm> perms) {
        String sql = "INSERT INTO auroleperm(ROLEID,PERMID) VALUES(?,?)";
        this.getTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setLong(1, roleID);
                ps.setInt(2, perms.get(i).getPermID());
            }

            @Override
            public int getBatchSize() {
                return perms.size();
            }
        });
    }

    public void removePerm(int roleID, List<AuthPerm> perms) {
        String sql = "DELETE FROM auroleperm WHERE ROLEID=? AND PERMID=?";
        this.getTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setLong(1, roleID);
                ps.setInt(2, perms.get(i).getPermID());
            }

            @Override
            public int getBatchSize() {
                return perms.size();
            }
        });
    }

    public long count() {
        String sql = "SELECT COUNT(1) FROM AUROLE";
        return this.queryObject(sql, Long.class);
    }

    public List<AuthRole> search(int pageNum, int pageSize) {
        int start = (pageNum - 1) * pageSize;
        return this.querySQL("SELECT * FROM AUROLE ORDER BY ROLEID LIMIT ? OFFSET ?", new AuthRoleRowMapper(), pageSize,
                start);
    }

    public Long countRole(Integer roleId) {
        String sql = "SELECT COUNT(1) FROM auuserrole WHERE ROLEID = ?";
        return this.queryObject(sql, Long.class, roleId);
    }

    public List<AuthRole> list(Long appId, String userId) {
        return this.querySQL(
                "SELECT * FROM aurole AS role INNER JOIN auuserrole AS ur ON role.ROLEID = ur.ROLEID  WHERE ur.APPID = ? AND ur.USERID = ?",
                new AuthRoleRowMapper(), appId, userId);
    }
}
