package org.yunzhong.account.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.yunzhong.account.admin.model.TrxCat;

public class TrxCatDao extends AcctBasicDao<TrxCat> {
    public static class TrxCatRowMapper implements RowMapper<TrxCat> {

        @Override
        public TrxCat mapRow(ResultSet rs, int rowNum) throws SQLException {
            TrxCat type = new TrxCat();
            type.setTrxCode(rs.getString("TRXCODE"));
            type.setTrxCat(rs.getInt("TRXCAT"));
            type.setTrxDir(rs.getString("TRXDIR"));
            type.setTrxName(rs.getString("TRXNAME"));
            return type;
        }

    }

    public List<TrxCat> getAll() {
        return this.querySQL("SELECT * FROM TRXCAT ORDER BY TRXCODE", new TrxCatRowMapper());
    }

    public int delete(String trxCode) {
        String sql = "DELETE FROM trxcat WHERE TRXCODE = ?";
        return this.updateSQL(sql, trxCode);
    }

    public int update(TrxCat trxCat) {
        String sql = "UPDATE trxcat SET TRXCAT=?,TRXNAME=?,TRXDIR=? WHERE TRXCODE = ?";
        return this.updateSQL(sql, trxCat.getTrxCat(), trxCat.getTrxName(), trxCat.getTrxDir(), trxCat.getTrxCode());
    }

    public int add(TrxCat trxCat) {
        String sql = "INSERT INTO trxcat(TRXCODE, TRXCAT, TRXNAME, TRXDIR) VALUES(?,?,?,?)";
        return this.updateSQL(sql, trxCat.getTrxCode(), trxCat.getTrxCat(), trxCat.getTrxName(), trxCat.getTrxDir());
    }
}
