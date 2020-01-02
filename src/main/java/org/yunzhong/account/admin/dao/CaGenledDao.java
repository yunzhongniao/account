package org.yunzhong.account.admin.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.yunzhong.account.admin.model.Cagenled;

public class CaGenledDao extends AcctBasicDao<Object> {

    public Long countOrg(String osbId) {
        String sql = "SELECT count(1) FROM cagenled as genled  WHERE genled.OSBID = ? ";
        return this.queryObject(sql, Long.class, osbId);
    }
    
    public int update(Cagenled cagenled) {
        String sql = "UPDATE cagenled SET OSBID = ? , ITEMCODE = ? , ITEMBALBY = ? , ITEMCLASS = ? , CURRTYPE = ?  where  OSBID = ? and ITEMCODE = ?";
        return this.updateSQL(sql, cagenled.getOsbID(), cagenled.getItemCode(), cagenled.getItemBalby(), cagenled.getItemClass(),
                cagenled.getCurrType());
    }
    
    public int delete(String osbID, String itemCode) {
        String sql = "DELETE FROM cagenled where OSBID = ? AND ITEMCODE = ?";
        return this.updateSQL(sql, osbID, itemCode);
    }

    public int add(Cagenled cagenled) {
        String sql = "INSERT INTO cagenled(OSBID, ITEMCODE, ITEMBALBY, ITEMCLASS, CURRTYPE) VALUES(?,?,?,?,?)";
        return this.updateSQL(sql, cagenled.getOsbID(), cagenled.getItemCode(), cagenled.getItemBalby(), cagenled.getItemClass(),
                cagenled.getCurrType());
    }
    
    public void batchAdd(List<Cagenled> cagenleds) {
        String sql = "INSERT INTO cagenled(OSBID, ITEMCODE, ITEMBALBY, ITEMCLASS, CURRTYPE) VALUES(?,?,?,?,?)";
        this.getTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Cagenled cagenled = cagenleds.get(i);
                ps.setString(1, cagenled.getOsbID());
                ps.setString(2, cagenled.getItemCode());
                ps.setInt(3, cagenled.getItemBalby()==null?0:cagenled.getItemBalby());
                ps.setInt(4, cagenled.getItemClass()==null?0:cagenled.getItemClass());
                ps.setString(5, cagenled.getCurrType());
            }

            @Override
            public int getBatchSize() {
                return cagenleds.size();
            }
        });
    }

    public void batchUpdate(List<Cagenled> cagenleds) {
        String sql = "UPDATE cagenled SET ITEMBALBY = ?,ITEMCLASS =?,CURRTYPE = ? WHERE OSBID = ? AND ITEMCODE = ?";
        this.getTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Cagenled cagenled = cagenleds.get(i);
                ps.setInt(1, cagenled.getItemBalby()==null?0:cagenled.getItemBalby());
                ps.setInt(2, cagenled.getItemClass()==null?0:cagenled.getItemClass());
                ps.setString(3, cagenled.getCurrType());
                ps.setString(4, cagenled.getOsbID());
                ps.setString(5, cagenled.getItemCode());
            }

            @Override
            public int getBatchSize() {
                return cagenleds.size();
            }
        });
    }
}
