package org.yunzhong.account.admin.dao;

import org.yunzhong.account.admin.model.AcctCus;

public class AcctCusDao extends AcctBasicDao<AcctCus> {

    /**
     * 查询账户类型下的账户有多少个
     * 
     * @param osbType
     * @param acctType
     * @return
     */
    public Long count(String osbType, String acctType) {
        String sql = "SELECT count(1) FROM caacctcus as cus INNER JOIN caacctosb as osb ON cus.OSBID = osb.OSBID WHERE osb.OSBTYPE = ? AND cus.ACCTTYPE = ? ";
        return this.queryObject(sql, Long.class, osbType, acctType);
    }
    
    public Long countItem(String osbType, String itemCode){
        String sql =  "SELECT count(1) FROM caacctcus as cus INNER JOIN caacctosb as osb ON cus.OSBID = osb.OSBID WHERE osb.OSBTYPE = ? AND cus.ITEMCODE = ? ";
        return this.queryObject(sql, Long.class, osbType, itemCode);
    }
    
    public Long countCurrType(String currType){
        String sql =  "SELECT COUNT(1) FROM caacctcus WHERE CURRTYPE = ? ";
        return this.queryObject(sql, Long.class, currType);
    }

    public Long countCa(String osbType, String caTypeId) {
        String sql =  "SELECT count(1) FROM caacctcus as cus INNER JOIN caacctosb as osb ON cus.OSBID = osb.OSBID WHERE osb.OSBTYPE = ? AND cus.ACCTCATYPE = ? ";
        return this.queryObject(sql, Long.class, osbType, caTypeId);
    }
    
    public Long countOrg(String osbId) {
        String sql =  "SELECT count(1) FROM caacctcus as cus WHERE cus.OSBID = ? ";
        return this.queryObject(sql, Long.class, osbId);
    }

}
