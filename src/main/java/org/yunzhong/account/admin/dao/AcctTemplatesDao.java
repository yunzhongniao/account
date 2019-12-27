package org.yunzhong.account.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;
import org.yunzhong.account.admin.model.AcctTemplate;

public class AcctTemplatesDao extends AcctBasicDao<AcctTemplate> {
    public static class AcctTemplatesRowMapper implements RowMapper<AcctTemplate> {

        @Override
        public AcctTemplate mapRow(ResultSet rs, int rowNum) throws SQLException {
            AcctTemplate template = new AcctTemplate();
            template.setOsbType(rs.getString("OSBTYPE"));
            template.setTplId(rs.getLong("TPLID"));
            template.setTplName(rs.getString("TPLNAME"));
            template.setAcctNamePfx(rs.getString("ACCTNAMEPFX"));
            template.setAcctNameAfx(rs.getString("ACCTNAMEAFX"));
            template.setAcctStatus(rs.getString("ACCTSTATUS"));
            template.setAcctType(rs.getString("ACCTTYPE"));
            template.setItemCode(rs.getString("ITEMCODE"));
            template.setItemName(rs.getString("ITEMNAME"));
            template.setForceFx(rs.getInt("FORCEFX"));
            template.setOcType(rs.getString("OCTYPE"));
            template.setAllowDeposit(rs.getInt("ALLOWDEPOSIT"));
            template.setAllowIn(rs.getInt("ALLOWIN"));
            template.setAllowOut(rs.getInt("ALLOWOUT"));
            template.setAllowPay(rs.getInt("ALLOWPAY"));
            template.setAllowRecharge(rs.getInt("ALLOWRECHARGE"));
            template.setAllowTfIn(rs.getInt("ALLOWTFIN"));
            template.setAllowTfOut(rs.getInt("ALLOWTFOUT"));
            return template;
        }

    }

    public long count(String osbType) {
        if (StringUtils.isEmpty(osbType)) {
            return this.queryObject("SELECT COUNT(1) FROM CAACCTTPL", Long.class);
        } else {
            return this.queryObject("SELECT COUNT(1) FROM CAACCTTPL WHERE OSBTYPE = ? ", Long.class, osbType);
        }
    }

    public long count(String osbType, String acctType) {
        return this.queryObject("SELECT COUNT(1) FROM CAACCTTPL WHERE OSBTYPE = ? AND ACCTTYPE = ? ", Long.class,
                osbType, acctType);
    }

    public List<AcctTemplate> search(String osbType, int pageNum, int pageSize) {
        int start = (pageNum - 1) * pageSize;
        if (!StringUtils.isEmpty(osbType)) {
            return this.querySQL(
                    "SELECT tpl.*,CAACCTITEM.ITEMNAME from (SELECT CAACCTTPL.* FROM CAACCTTPL WHERE OSBTYPE = ? ORDER BY TPLID LIMIT ? OFFSET ?) tpl JOIN CAACCTITEM ON TPL.ITEMCODE = CAACCTITEM.ITEMCODE AND TPL.OSBTYPE = CAACCTITEM.OSBTYPE",
                    new AcctTemplatesRowMapper(), osbType, pageSize, start);
        } else {
            return this.querySQL(
                    "SELECT tpl.*,CAACCTITEM.ITEMNAME from (SELECT CAACCTTPL.* FROM CAACCTTPL ORDER BY TPLID LIMIT ? OFFSET ?) tpl JOIN CAACCTITEM ON TPL.ITEMCODE = CAACCTITEM.ITEMCODE AND TPL.OSBTYPE = CAACCTITEM.OSBTYPE",
                    new AcctTemplatesRowMapper(), pageSize, start);
        }
    }

    public int delete(long tplId) {
        String sql = "DELETE FROM CAACCTTPL WHERE TPLID = ?";
        return this.updateSQL(sql, tplId);
    }

    public int update(AcctTemplate template) {
        String sql = "UPDATE CAACCTTPL SET TPLNAME = ?,ACCTTYPE=?,ACCTNAMEPFX=?,ACCTNAMEAFX=?,FORCEFX=?,ACCTSTATUS=?,ITEMCODE=?,OCTYPE=?"
                + ",ALLOWPAY=?,ALLOWRECHARGE=?,ALLOWDEPOSIT=?,ALLOWTFIN=?,ALLOWTFOUT=?,ALLOWIN=?,ALLOWOUT=? WHERE TPLID = ?";
        return this.updateSQL(sql, template.getTplName(), template.getAcctType(), template.getAcctNamePfx(),
                template.getAcctNameAfx(), template.getForceFx(), template.getAcctStatus(), template.getItemCode(),template.getOcType(),
                template.getAllowPay(), template.getAllowRecharge(), template.getAllowDeposit(), template.getAllowTfIn(), template.getAllowTfOut(),
                template.getAllowIn(), template.getAllowOut(),
                template.getTplId());
    }

    public int add(AcctTemplate template) {
        String sql = "INSERT INTO CAACCTTPL(OSBTYPE, TPLNAME, ACCTTYPE, ACCTNAMEPFX, ACCTNAMEAFX, FORCEFX, ACCTSTATUS,ITEMCODE,OCTYPE"
                + ",ALLOWPAY, ALLOWRECHARGE, ALLOWDEPOSIT, ALLOWTFIN, ALLOWTFOUT, ALLOWIN, ALLOWOUT) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return this.updateSQL(sql, template.getOsbType(), template.getTplName(), template.getAcctType(),
                template.getAcctNamePfx(), template.getAcctNameAfx(), template.getForceFx(), template.getAcctStatus(),
                template.getItemCode(),template.getOcType(),template.getAllowPay(), template.getAllowRecharge(), template.getAllowDeposit(), template.getAllowTfIn(), template.getAllowTfOut(),
                template.getAllowIn(), template.getAllowOut());
    }

    /**
     * item 在模板里面的使用数目
     * 
     * @param osbType
     * @param itemCode
     * @return
     */
    public Long countItem(String osbType, String itemCode) {
        String sql = "SELECT count(1) FROM caaccttpl as tpl WHERE tpl.OSBTYPE = ? AND tpl.ITEMCODE = ? ";
        return this.queryObject(sql, Long.class, osbType, itemCode);
    }

    /**
     * 载体类型 在模板里面的使用数目
     * 
     * @param osbType
     * @param caTypeId
     * @return
     */
    public Long countCa(String osbType, String caTypeId) {
        String sql = "SELECT count(1) FROM caaccttpl as tpl WHERE tpl.OSBTYPE = ? AND tpl.OCTYPE = ? ";
        return this.queryObject(sql, Long.class, osbType, caTypeId);
    }
}
