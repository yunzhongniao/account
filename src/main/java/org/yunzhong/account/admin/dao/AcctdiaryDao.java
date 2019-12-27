package org.yunzhong.account.admin.dao;

public class AcctdiaryDao extends AcctBasicDao<Object> {

    /**
     * item 在日表里面的使用数目
     * 
     * @param osbType
     * @param itemCode
     * @return
     */
    public Long countItem(String osbType, String itemCode) {
        String sql = "SELECT count(1) FROM caacctdiary as diary INNER JOIN caacctosb as osb ON diary.OSBID = osb.OSBID WHERE osb.OSBTYPE = ? AND diary.ITEMCODE = ? ";
        return this.queryObject(sql, Long.class, osbType, itemCode);
    }
    
    public Long countCurrType(String currType){
        String sql =  "SELECT COUNT(1) FROM caacctdiary WHERE CURRTYPE = ? ";
        return this.queryObject(sql, Long.class, currType);
    }

    public Long countOrg(String osbId) {
        String sql = "SELECT count(1) FROM caacctdiary as diary WHERE diary.OSBID = ? ";
        return this.queryObject(sql, Long.class, osbId);
    }

}
