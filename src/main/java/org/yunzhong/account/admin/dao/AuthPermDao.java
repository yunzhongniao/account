package org.yunzhong.account.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;
import org.yunzhong.account.admin.model.AuthPerm;
import org.yunzhong.account.common.dict.CphAcctConsts;

public class AuthPermDao extends AcctBasicDao<AuthPerm> {

    public static class AuthPermRowMapper implements RowMapper<AuthPerm> {

        @Override
        public AuthPerm mapRow(ResultSet rs, int rowNum) throws SQLException {
            AuthPerm perm = new AuthPerm();
            perm.setPerm(rs.getString("PERM"));
            perm.setPermID(rs.getInt("PERMID"));
            perm.setPermName(rs.getString("PERMNAME"));
            perm.setPermType(rs.getString("PERMTYPE"));
            return perm;
        }

    }

    public List<AuthPerm> getAll() {
        return this.querySQL("SELECT * FROM AUPERM ORDER BY PERMID", new AuthPermRowMapper());
    }

    public int update(AuthPerm perm) {
        String sql = "UPDATE AUPERM SET PERMNAME = ?,PERMTYPE = ?,PERM = ? where  PERMID = ? ";
        return this.updateSQL(sql, perm.getPermName(), perm.getPermType(), perm.getPerm(), perm.getPermID());
    }

    public int add(AuthPerm perm) {
        String sql = "INSERT INTO AUPERM(PERMNAME, PERMTYPE, PERM) VALUES(?,?,?)";
        return this.updateSQL(sql, perm.getPermName(), StringUtils.isEmpty(perm.getPermType())?CphAcctConsts.AUPERM_TYPE_INTERFACE:perm.getPermType(), perm.getPerm());
    }

    public int delete(int permID) {
        String sql = "DELETE FROM AUPERM where PERMID = ?";
        return this.updateSQL(sql, permID);
    }
}
