package org.yunzhong.account.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.yunzhong.account.admin.model.CurrType;
import org.yunzhong.account.common.dict.CphAcctConsts;

public class CurrTypeDao extends AcctBasicDao<CurrType> {

    public static class CurrTypeRowMapper implements RowMapper<CurrType> {

        @Override
        public CurrType mapRow(ResultSet rs, int rowNum) throws SQLException {
            CurrType type = new CurrType();
            type.setCurrLocal(rs.getString("CURRLOCAL"));
            type.setCurrName(rs.getString("CURRNAME"));
            type.setCurrType(rs.getString("CURRTYPE"));
            return type;
        }

    }

    public List<CurrType> getAll() {
        return this.querySQL("SELECT * FROM CDCURRTYPE ORDER BY CURRLOCAL desc", new CurrTypeRowMapper());
    }

    public int update(CurrType type) {
        String sql = "UPDATE CDCURRTYPE SET CURRNAME = ?  where  CURRTYPE = ? ";
        return this.updateSQL(sql, type.getCurrName(), type.getCurrType());
    }

    public int add(CurrType type) {
        String sql = "INSERT INTO CDCURRTYPE( CURRTYPE, CURRNAME, CURRLOCAL) VALUES(?,?,?)";
        return this.updateSQL(sql, type.getCurrType(), type.getCurrName(), CphAcctConsts.CURRLOCAL_NO);
    }

    public int delete(String type) {
        String sql = "DELETE FROM CDCURRTYPE where CURRTYPE = ?";
        return this.updateSQL(sql, type);
    }
}
