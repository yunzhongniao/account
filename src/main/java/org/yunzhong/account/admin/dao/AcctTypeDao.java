package org.yunzhong.account.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.yunzhong.account.admin.model.AcctType;

public class AcctTypeDao extends AcctBasicDao<AcctType> {
    public static class AcctTypeRowMapper implements RowMapper<AcctType> {

        @Override
        public AcctType mapRow(ResultSet rs, int rowNum) throws SQLException {
            AcctType type = new AcctType();
            type.setOsbType(rs.getString("OSBTYPE"));
            type.setAcctType(rs.getString("ACCTTYPE"));
            type.setTypeName(rs.getString("TYPENAME"));
            return type;
        }

    }

    public List<AcctType> getAll(String osbType) {
        return this.querySQL("SELECT * FROM CAACCTTYPE WHERE OSBTYPE = ? ORDER BY ACCTTYPE", new AcctTypeRowMapper(), osbType);
    }

    public int delete(String osbType, String acctType) {
        String sql = "DELETE FROM CAACCTTYPE WHERE OSBTYPE = ? AND ACCTTYPE = ?";
        return this.updateSQL(sql, osbType, acctType);
    }

    public int update(AcctType type) {
        String sql = "UPDATE CAACCTTYPE SET TYPENAME = ? WHERE OSBTYPE = ? AND ACCTTYPE = ?";
        return this.updateSQL(sql, type.getTypeName(), type.getOsbType(), type.getAcctType());
    }

    public int add(AcctType type) {
        String sql = "INSERT INTO CAACCTTYPE(OSBTYPE, ACCTTYPE, TYPENAME) VALUES(?,?,?)";
        return this.updateSQL(sql, type.getOsbType(), type.getAcctType(), type.getTypeName());
    }
}
