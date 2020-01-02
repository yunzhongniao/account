package org.yunzhong.account.admin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;
import org.yunzhong.account.admin.model.AcctItem;

public class AcctItemDao extends AcctBasicDao<AcctItem> {

    public static class AcctItemRowMapper implements RowMapper<AcctItem> {

        @Override
        public AcctItem mapRow(ResultSet rs, int rowNum) throws SQLException {
            AcctItem type = new AcctItem();
            type.setOsbType(rs.getString("OSBTYPE"));
            type.setItemCode(rs.getString("ITEMCODE"));
            type.setItemName(rs.getString("ITEMNAME"));
            type.setItemBalby(rs.getInt("ITEMBALBY"));
            type.setItemClass(rs.getInt("ITEMCLASS"));
            type.setItemNotes(rs.getString("ITEMNOTES"));
            type.setItemLevel(rs.getInt("ITEMLEVEL"));
            type.setItemFather(rs.getString("ITEMFATHER"));
            type.setCurrType(rs.getString("CURRTYPE"));
            type.setCurrTypeName(rs.getString("CURRNAME"));
            type.setMainAcct(rs.getInt("MAINACCT"));
            type.setCqAcct(rs.getInt("CQACCT"));
            return type;
        }

    }

    public List<AcctItem> getAll(String osbType, Integer itemClass) {
        if (StringUtils.isEmpty(itemClass)) {
            return this.querySQL("SELECT item.*, ctype.CURRNAME FROM CAACCTITEM as item LEFT JOIN cdcurrtype ctype ON item.CURRTYPE=ctype.CURRTYPE WHERE OSBTYPE = ? ORDER BY ITEMCODE",
                    new AcctItemRowMapper(), osbType);
        } else {
            return this.querySQL("SELECT item.*, ctype.CURRNAME FROM CAACCTITEM as item LEFT JOIN cdcurrtype ctype ON item.CURRTYPE=ctype.CURRTYPE WHERE OSBTYPE = ? AND ITEMCLASS = ? ORDER BY ITEMCODE",
                    new AcctItemRowMapper(), osbType, itemClass);
        }
    }
    
    public List<AcctItem> getLevel1Item(String osbType) {
        return this.querySQL("SELECT item.*, ctype.CURRNAME FROM CAACCTITEM as item LEFT JOIN cdcurrtype ctype ON item.CURRTYPE=ctype.CURRTYPE WHERE OSBTYPE = ? AND ITEMLEVEL = 1 ORDER BY ITEMCODE",
                new AcctItemRowMapper(), osbType);
    }

    public int update(AcctItem item) {
        String sql = "UPDATE caacctitem SET ITEMNAME = ? , ITEMBALBY = ? , ITEMCLASS = ? , ITEMNOTES = ? , ITEMLEVEL = ? , ITEMFATHER = ? , CURRTYPE = ? , MAINACCT = ? , CQACCT = ?  where  OSBTYPE = ? and ITEMCODE = ?";
        return this.updateSQL(sql, item.getItemName(), item.getItemBalby(), item.getItemClass(), item.getItemNotes(),
                item.getItemLevel(), item.getItemFather(), item.getCurrType(), item.getMainAcct(), item.getCqAcct(),
                item.getOsbType(), item.getItemCode());
    }

    public int add(AcctItem item) {
        String sql = "INSERT INTO caacctitem( OSBTYPE, ITEMCODE, ITEMNAME, ITEMBALBY, ITEMCLASS, ITEMNOTES, ITEMLEVEL, ITEMFATHER, CURRTYPE, MAINACCT, CQACCT) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        return this.updateSQL(sql, item.getOsbType(), item.getItemCode(), item.getItemName(), item.getItemBalby(),
                item.getItemClass(), item.getItemNotes(), item.getItemLevel(), item.getItemFather(), item.getCurrType(),
                item.getMainAcct(), item.getCqAcct());

    }
    
    public void batchAdd(List<AcctItem> items) {
        String sql = "INSERT INTO caacctitem( OSBTYPE, ITEMCODE, ITEMNAME, ITEMBALBY, ITEMCLASS, ITEMNOTES, ITEMLEVEL, ITEMFATHER, CURRTYPE, MAINACCT, CQACCT) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        this.getTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                AcctItem item = items.get(i);
                ps.setString(1, item.getOsbType());
                ps.setString(2, item.getItemCode());
                ps.setString(3, item.getItemName());
                ps.setInt(4, item.getItemBalby()==null?0:item.getItemBalby());
                ps.setInt(5, item.getItemClass()==null?0:item.getItemClass());
                ps.setString(6, item.getItemNotes());
                ps.setInt(7, item.getItemLevel()==null?0:item.getItemLevel());
                ps.setString(8, item.getItemFather());
                ps.setString(9, item.getCurrType());
                ps.setInt(10, item.getMainAcct()==null?0:item.getMainAcct());
                ps.setInt(11, item.getCqAcct()==null?0:item.getCqAcct());
            }

            @Override
            public int getBatchSize() {
                return items.size();
            }
        });
    }

    public int delete(String osbType, String itemCode) {
        String sql = "DELETE FROM caacctitem where OSBTYPE = ? AND ITEMCODE = ?";
        return this.updateSQL(sql, osbType, itemCode);
    }
}
