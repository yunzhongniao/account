package org.yunzhong.account.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.yunzhong.account.admin.model.TrxBook;

public class TrxBookDao extends AcctBasicDao<TrxBook> {
    public static class TrxBookRowMapper implements RowMapper<TrxBook> {

        @Override
        public TrxBook mapRow(ResultSet rs, int rowNum) throws SQLException {
            TrxBook tr = new TrxBook();
            tr.setTrxId(rs.getString("TRXID"));
            tr.setPaymentAmount(rs.getBigDecimal("PAYMENT_AMOUNT"));
            tr.setCusNum(rs.getString("CUS_NUM"));
            tr.setCusName(rs.getString("CUS_NAME"));
            tr.setOtherNum(rs.getString("OTHER_NUM"));
            tr.setOtherName(rs.getString("OTHER_NAME"));
            tr.setTrxDir(rs.getString("TRX_DIR"));
            tr.setOsbId(rs.getString("OSB_ID"));
            tr.setAmount(rs.getBigDecimal("AMOUNT"));
            tr.setTrxCode(rs.getString("TRX_CODE"));
            tr.setPayChannelId(rs.getInt("PAYCHANNEL_ID"));
            tr.setBankCode(rs.getString("BANK_CODE"));
            tr.setTransDate(rs.getDate("TRANS_DATE"));
            tr.setAccountDate(rs.getDate("ACCOUNT_DATE"));
            tr.setCurrency(rs.getString("CURRENCY"));
            tr.setSummary(rs.getString("SUMMARY"));
            tr.setRemarks(rs.getString("REMARKS"));
            return tr;
        }

    }

    public int add(TrxBook trxBook) {
        String sql = "INSERT INTO acct_trxbook(`CUS_NUM`, `REMARKS`, `ACCOUNT_DATE`, `CUS_NAME`, `TRX_DIR`, `TRX_CODE`, `PAYMENT_AMOUNT`, `OTHER_NUM`, `BANK_CODE`, `OTHER_NAME`, `CURRENCY`, `OSB_ID`,`AMOUNT`, `TRXID`, `TRANS_DATE`, `SUMMARY`, `PAYCHANNEL_ID`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return this.updateSQL(sql, trxBook.getCusNum(),trxBook.getRemarks(),trxBook.getAccountDate(),trxBook.getCusName(),trxBook.getTrxDir(),trxBook.getTrxCode(),trxBook.getPaymentAmount(),trxBook.getOtherNum(),trxBook.getBankCode(),trxBook.getOtherName(),trxBook.getCurrency(),trxBook.getOsbId(),trxBook.getAmount(),trxBook.getTrxId(),trxBook.getTransDate(),trxBook.getSummary(),trxBook.getPayChannelId());
    }
}
