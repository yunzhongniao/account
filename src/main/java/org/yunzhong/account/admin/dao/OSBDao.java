package org.yunzhong.account.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.yunzhong.account.admin.model.OrgSalesBook;

public class OSBDao extends AcctBasicDao<OrgSalesBook> {

    public static class OrgSalesBookRowMapper implements RowMapper<OrgSalesBook> {

        @Override
        public OrgSalesBook mapRow(ResultSet rs, int rowNum) throws SQLException {
            OrgSalesBook osb = new OrgSalesBook();
            osb.setOsbName(rs.getString("OSBNAME"));
            osb.setOsbType(rs.getString("OSBTYPE"));
            return osb;
        }

    }

    public List<OrgSalesBook> getAll() {
        String sql = "SELECT * FROM CAOSBTYPE";
        return this.querySQL(sql, new OrgSalesBookRowMapper());
    }
    
    public List<OrgSalesBook> getByOsbType(String osbType) {
        String sql = "SELECT * FROM CAOSBTYPE WHERE OSBTYPE = ?";
        return this.querySQL(sql, new OrgSalesBookRowMapper(), osbType);
    }

    public int delete(String osbType) {
        String sql = "DELETE FROM CAOSBTYPE WHERE OSBTYPE = ? AND NOT EXISTS (SELECT * FROM CAACCTOSB WHERE OSBTYPE = ?)";
        return this.updateSQL(sql, osbType, osbType);
    }

    public int update(OrgSalesBook osb) {
        String sql = "UPDATE CAOSBTYPE SET OSBNAME = ? WHERE OSBTYPE = ?";
        return this.updateSQL(sql, osb.getOsbName(), osb.getOsbType());
    }

    public int add(OrgSalesBook osb) {
        String sql = "INSERT INTO CAOSBTYPE(OSBNAME, OSBTYPE) VALUES(?,?)";
        return this.updateSQL(sql, osb.getOsbName(), osb.getOsbType());
    }
}
