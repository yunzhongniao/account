package org.yunzhong.account.admin.dao;

import org.yunzhong.account.admin.model.AcctENY;

public class AcctENYDao extends AcctBasicDao<AcctENY> {

    /**
     * 查询账户类型下的分录规则有多少个
     * 
     * @param osbType
     * @param acctType
     * @return
     */
    public Long count(String osbType, String acctType) {
        String sql = "SELECT count(1) FROM caaccteny as eny INNER JOIN caacctosb as osb ON eny.OSBID = osb.OSBID WHERE osb.OSBTYPE = ? AND eny.ACCTTYPE = ?";
        return this.queryObject(sql, Long.class, osbType, acctType);
    }

    public Long countOrg(String osbId) {
        String sql = "SELECT count(1) FROM caaccteny as eny  WHERE eny.OSBID = ? ";
        return this.queryObject(sql, Long.class, osbId);
    }

    public Long countTrx(String trxCode) {
        String sql = "SELECT count(1) FROM caaccteny as eny  WHERE eny.TRXCODE = ? ";
        return this.queryObject(sql, Long.class, trxCode);
    }

}
