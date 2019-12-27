package org.yunzhong.account.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.yunzhong.account.admin.model.AcctCaType;

public class AcctCaTypeDao extends AcctBasicDao<AcctCaType> {
    public static class AcctCaTypeRowMapper implements RowMapper<AcctCaType> {

        @Override
        public AcctCaType mapRow(ResultSet rs, int rowNum) throws SQLException {
            AcctCaType type = new AcctCaType();
            type.setOsbType(rs.getString("OSBTYPE"));
            type.setCaTypeId(rs.getString("CATYPEID"));
            type.setCaTypeName(rs.getString("CATYPENAME"));
            type.setIsCus(rs.getInt("ISCUS"));
            return type;
        }

    }

    public List<AcctCaType> getAll(String osbType) {
        return this.querySQL("SELECT * FROM CAACCTCATYPE WHERE OSBTYPE = ? ORDER BY CATYPEID",
                new AcctCaTypeRowMapper(), osbType);
    }

    public int delete(String osbType, String caTypeId) {
        String sql = "DELETE FROM CAACCTCATYPE WHERE OSBTYPE = ? AND CATYPEID = ?";
        return this.updateSQL(sql, osbType, caTypeId);
    }

    public int update(AcctCaType caType) {
        String sql = "UPDATE CAACCTCATYPE SET CATYPENAME = ? , ISCUS= ? WHERE OSBTYPE = ? AND CATYPEID = ?";
        return this.updateSQL(sql, caType.getCaTypeName(), caType.getIsCus(), caType.getOsbType(),
                caType.getCaTypeId());
    }

    public int add(AcctCaType caType) {
        String sql = "INSERT INTO CAACCTCATYPE(OSBTYPE, CATYPEID, CATYPENAME,ISCUS) VALUES(?,?,?,?)";
        return this.updateSQL(sql, caType.getOsbType(), caType.getCaTypeId(), caType.getCaTypeName(),
                caType.getIsCus());
    }
}
