package org.yunzhong.account.admin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.CollectionUtils;
import org.yunzhong.account.admin.model.AcctEF;

public class AcctEFDao extends AcctBasicDao<AcctEF> {

    public static class AcctEFRowMapper implements RowMapper<AcctEF> {

        @Override
        public AcctEF mapRow(ResultSet rs, int rowNum) throws SQLException {
            AcctEF acctEF = new AcctEF();
            acctEF.setAcctcaType(rs.getString("ACCTCATYPE"));
            acctEF.setAcctNature(rs.getString("ACCTNATURE"));
            acctEF.setAcctNo(rs.getString("ACCTNO"));
            acctEF.setAcctType(rs.getString("ACCTTYPE"));
            acctEF.setActionX(rs.getString("ACTIONX"));
            acctEF.setAmount(rs.getString("AMOUNT"));
            acctEF.setCrDr(rs.getInt("CRDR"));
            acctEF.setEfId(rs.getLong("EFID"));
            acctEF.setEfName(rs.getString("EFNAME"));
            acctEF.setEntryGrp(rs.getInt("ENTRYGRP"));
            acctEF.setEntryPty(rs.getInt("ENTRYPTY"));
            acctEF.setEntrySubGrp(rs.getInt("ENTRYSUBGRP"));
            acctEF.setGenledAtonce(rs.getInt("GENLEDATONCE"));
            acctEF.setItemCode(rs.getString("ITEMCODE"));
            acctEF.setItemName(rs.getString("ITEMNAME"));
            acctEF.setOrgCode(rs.getString("ORGCODE"));
            acctEF.setOrgType(rs.getString("ORGTYPE"));
            acctEF.setOsbType(rs.getString("OSBTYPE"));
            acctEF.setPid(rs.getString("PID"));
            acctEF.setPostAtonce(rs.getInt("POSTATONCE"));
            acctEF.setRecipAcctNo(rs.getString("RECIPACCTNO"));
            acctEF.setRecipOrgCode(rs.getString("RECIPORGCODE"));
            acctEF.setTrxCode(rs.getString("TRXCODE"));
            acctEF.setTrxDir(rs.getString("TRXDIR"));
            return acctEF;
        }

    }

    /**
     * 查询账户类型下的分录规则有多少个
     * 
     * @param osbType
     * @param acctType
     * @return
     */
    public Long count(String osbType, String acctType) {
        String sql = "SELECT count(1) FROM caacctef as ef WHERE ef.OSBTYPE = ? AND ef.ACCTTYPE = ?";
        return this.queryObject(sql, Long.class, osbType, acctType);
    }

    public List<AcctEF> getAll(String osbId) {
        String sql = "SELECT ef.*,item.ITEMNAME FROM caacctef as ef LEFT JOIN caacctitem as item ON ef.ITEMCODE=item.ITEMCODE WHERE ef.PID = ? AND ef.OSBTYPE=item.OSBTYPE ORDER BY TRXCODE";
        return this.querySQL(sql, new AcctEFRowMapper(), osbId);
    }

    public int delete(String osbType, String trxCode) {
        String sql = "DELETE FROM caacctef where PID = ? AND TRXCODE = ?";
        return this.updateSQL(sql, osbType, trxCode);
    }

    public void deleteOther(String pid, String trxCode, List<AcctEF> updateEFs) {
        if (CollectionUtils.isEmpty(updateEFs)) {
            String sql = "DELETE FROM caacctef WHERE PID = ? AND TRXCODE = ?";
            this.updateSQL(sql, pid, trxCode);
        } else {
            String sql = "DELETE FROM caacctef WHERE PID = ? AND TRXCODE = ? AND EFID NOT IN (";
            StringBuilder builder = new StringBuilder(sql);
            Iterator<AcctEF> iterator = updateEFs.iterator();
            builder.append(iterator.next().getEfId());
            while (iterator.hasNext()) {
                builder.append("," + iterator.next().getEfId());
            }
            builder.append(")");
            this.updateSQL(builder.toString(), pid, trxCode);
        }
    }

    public void batchAdd(List<AcctEF> newEFs) {
        String sql = "INSERT INTO caacctef(EFNAME,OSBTYPE,TRXDIR,PID,TRXCODE,ACTIONX,ENTRYGRP,ENTRYSUBGRP,ENTRYPTY,ORGTYPE,ORGCODE,ACCTNATURE,ACCTCATYPE,ACCTTYPE,ACCTNO,ITEMCODE,CRDR,AMOUNT) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        this.getTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                AcctEF ef = newEFs.get(i);
                ps.setString(1, ef.getEfName());
                ps.setString(2, ef.getOsbType());
                ps.setString(3, ef.getTrxDir());
                ps.setString(4, ef.getPid());
                ps.setString(5, ef.getTrxCode());
                ps.setString(6, ef.getActionX());
                ps.setInt(7, ef.getEntryGrp() == null ? 1 : ef.getEntryGrp());
                ps.setInt(8, ef.getEntrySubGrp() == null ? 1 : ef.getEntrySubGrp());
                ps.setInt(9, ef.getEntryPty());
                ps.setString(10, ef.getOrgType());
                ps.setString(11, ef.getOrgCode());
                ps.setString(12, ef.getAcctNature());
                ps.setString(13, ef.getAcctcaType());
                ps.setString(14, ef.getAcctType());
                ps.setString(15, ef.getAcctNo());
                ps.setString(16, ef.getItemCode());
                ps.setInt(17, ef.getCrDr());
                ps.setString(18, ef.getAmount());
            }

            @Override
            public int getBatchSize() {
                return newEFs.size();
            }
        });
    }

    public void batchUpdate(List<AcctEF> updateEFs) {
        String sql = "UPDATE caacctef SET EFNAME = ?,TRXDIR =?,ACTIONX = ?,ENTRYGRP =?,ENTRYSUBGRP =?,ENTRYPTY =?,ORGTYPE =?,ORGCODE=?,ACCTNATURE=?,ACCTCATYPE=?,ACCTTYPE=?,ACCTNO =?,ITEMCODE =?,CRDR =? ,AMOUNT =? WHERE EFID = ?";
        this.getTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                AcctEF ef = updateEFs.get(i);
                ps.setString(1, ef.getEfName());
                ps.setString(2, ef.getTrxDir());
                ps.setString(3, ef.getActionX());
                ps.setInt(4, ef.getEntryGrp());
                ps.setInt(5, ef.getEntrySubGrp());
                ps.setInt(6, ef.getEntryPty());
                ps.setString(7, ef.getOrgType());
                ps.setString(8, ef.getOrgCode());
                ps.setString(9, ef.getAcctNature());
                ps.setString(10, ef.getAcctcaType());
                ps.setString(11, ef.getAcctType());
                ps.setString(12, ef.getAcctNo());
                ps.setString(13, ef.getItemCode());
                ps.setInt(14, ef.getCrDr());
                ps.setString(15, ef.getAmount());
                ps.setLong(16, ef.getEfId());
            }

            @Override
            public int getBatchSize() {
                return updateEFs.size();
            }
        });
    }

    /**
     * item 在分录规则里面的使用数目
     * 
     * @param osbType
     * @param itemCode
     * @return
     */
    public Long countItem(String osbType, String itemCode) {
        String sql = "SELECT count(1) FROM caacctef as ef WHERE ef.OSBTYPE = ? AND ef.ITEMCODE = ? ";
        return this.queryObject(sql, Long.class, osbType, itemCode);
    }

    public Long countTrx(String trxCode) {
        String sql = "SELECT count(1) FROM caacctef as ef WHERE ef.TRXCODE = ? ";
        return this.queryObject(sql, Long.class, trxCode);
    }

    public List<AcctEF> select(String pid, String trxCode) {
        String sql = "SELECT ef.*,item.ITEMNAME FROM caacctef as ef LEFT JOIN caacctitem as item ON ef.ITEMCODE=item.ITEMCODE WHERE ef.PID = ? AND ef.TRXCODE = ? AND ef.OSBTYPE=item.OSBTYPE ORDER BY TRXCODE";
        return this.querySQL(sql, new AcctEFRowMapper(), pid, trxCode);
    }
}
