package org.yunzhong.account.admin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.CollectionUtils;
import org.yunzhong.account.admin.model.AppUser;
import org.yunzhong.account.admin.model.AuthRole;

public class UserDao extends AcctBasicDao<AppUser> {
    public static class AppUserRowMapper implements RowMapper<AppUser> {

        @Override
        public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
            AppUser appUser = new AppUser();
            appUser.setAppId(rs.getLong("APPID"));
            appUser.setCrDate(rs.getTimestamp("CRDATE"));
            appUser.setCrUser(rs.getString("CRUSER"));
            appUser.setUserId(rs.getString("USERID"));
            return appUser;
        }

    }

    public AppUser checkUser(AppUser user) {
        String sql = "SELECT APPID,USERID,CRUSER,CRDATE FROM AUAPPUSER WHERE USERID = ? AND USERPWD = ?";
        List<AppUser> users = this.querySQL(sql, new AppUserRowMapper(), user.getUserId(), user.getUserPwd());
        if (CollectionUtils.isEmpty(users)) {
            return null;
        }
        return users.get(0);
    }

    public Long countApp(Long appId) {
        String sql = "SELECT COUNT(1) FROM AUAPPUSER";
        if (appId != null) {
            sql = sql + " WHERE APPID = ?";
            return this.queryObject(sql, Long.class, appId);
        } else {
            return this.queryObject(sql, Long.class);
        }
    }

    public List<AppUser> search(Long appId, int pageNum, int pageSize) {
        int offset = (pageNum - 1) * pageSize;
        if (appId != null) {
            String sql = "SELECT * FROM AUAPPUSER WHERE APPID = ? ORDER BY USERID LIMIT ? OFFSET ?";
            return this.querySQL(sql, new AppUserRowMapper(), appId, pageSize, offset);
        } else {
            String sql = "SELECT * FROM AUAPPUSER ORDER BY USERID LIMIT ? OFFSET ?";
            return this.querySQL(sql, new AppUserRowMapper(), pageSize, offset);
        }
    }

    public int delete(Long appId, String userId) {
        String sql = "DELETE FROM auappuser WHERE APPID = ? AND USERID = ?";
        return this.updateSQL(sql, appId, userId);
    }

    public int deleteUserRole(Long appId, String userId) {
        String sql = "DELETE FROM auuserrole WHERE APPID = ? AND USERID = ?";
        return this.updateSQL(sql, appId, userId);
    }

    public int update(AppUser user) {
        String sql = "UPDATE auappuser SET USERPWD = ? WHERE APPID = ? AND USERID=?";
        return this.updateSQL(sql, user.getUserPwd(), user.getAppId(), user.getUserId());
    }

    public int add(AppUser user) {
        String sql = "INSERT INTO auappuser(APPID,USERID,USERPWD,CRUSER,CRDATE) VALUES(?,?,?,?,?)";
        return this.updateSQL(sql, user.getAppId(), user.getUserId(), user.getUserPwd(), user.getCrUser(),
                user.getCrDate() == null ? new Date() : user.getCrDate());
    }

    public void appendRole(String userId, Long appId, List<AuthRole> roles) {
        String sql = "INSERT INTO auuserrole(USERID,APPID,ROLEID) VALUES(?,?,?)";
        this.getTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, userId);
                ps.setLong(2, appId);
                ps.setInt(3, roles.get(i).getRoleID());
            }

            @Override
            public int getBatchSize() {
                return roles.size();
            }
        });
    }

    public void removeRole(String userId, long appId, List<AuthRole> roles) {
        String sql = "DELETE FROM auuserrole WHERE USERID=? AND APPID=? AND ROLEID=?";
        this.getTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, userId);
                ps.setLong(2, appId);
                ps.setInt(3, roles.get(i).getRoleID());
            }

            @Override
            public int getBatchSize() {
                return roles.size();
            }
        });
    }
}
