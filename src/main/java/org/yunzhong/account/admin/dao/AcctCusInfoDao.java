package org.yunzhong.account.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.yunzhong.account.admin.model.AcctCusInfo;

public class AcctCusInfoDao extends AcctBasicDao<AcctCusInfo> {

    public static class AcctCusInfoRowMapper implements RowMapper<AcctCusInfo> {

        @Override
        public AcctCusInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
            AcctCusInfo cusInfo = new AcctCusInfo();
            cusInfo.setAddress(rs.getString("ADDRESS"));
            cusInfo.setBirthday(rs.getString("BIRTHDAY"));
            cusInfo.setCertificateNumber(rs.getString("CERTIFICATENUMBER"));
            cusInfo.setCertificateType(rs.getString("CERTIFICATETYPE"));
            cusInfo.setCreateTime(StringUtils.isEmpty(rs.getString("CREATETIME")) ? rs.getString("CREATETIME")
                    : rs.getString("CREATETIME").substring(0, 19));
            cusInfo.setCusId(rs.getString("CUSID"));
            cusInfo.setEmail(rs.getString("EMAIL"));
            cusInfo.setMobile(rs.getString("MOBILE"));
            cusInfo.setName(rs.getString("NAME"));
            cusInfo.setOsbId(rs.getString("OSBID"));
            cusInfo.setPost(rs.getString("POST"));
            cusInfo.setRemark(rs.getString("REMARK"));
            cusInfo.setSex(rs.getString("SEX"));
            cusInfo.setUpdateTime(StringUtils.isEmpty(rs.getString("UPDATETIME")) ? rs.getString("UPDATETIME")
                    : rs.getString("UPDATETIME").substring(0, 19));
            return cusInfo;
        }
    }

    public List<AcctCusInfo> getAll() {
        return this.querySQL("SELECT * FROM CACUSINFO ORDER BY CUSID,OSBID", new AcctCusInfoRowMapper());
    }

    public int add(AcctCusInfo cusInfo) {
        String sql = "REPLACE INTO CACUSINFO(CUSID,OSBID,NAME,MOBILE,CERTIFICATETYPE,CERTIFICATENUMBER,SEX,BIRTHDAY,ADDRESS,EMAIL,POST,REMARK) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        return this.updateSQL(sql, cusInfo.getCusId(), cusInfo.getOsbId(), cusInfo.getName(), cusInfo.getMobile(),
                cusInfo.getCertificateType(), cusInfo.getCertificateNumber(), cusInfo.getSex(), cusInfo.getBirthday(),
                cusInfo.getAddress(), cusInfo.getEmail(), cusInfo.getPost(), cusInfo.getRemark());
    }

    public int delete(String cusId, String osbId) {
        String sql = "DELETE FROM CACUSINFO where CUSID = ? AND OSBID = ?";
        return this.updateSQL(sql, cusId, osbId);
    }

    public AcctCusInfo getOne(String cusId, String osbId) {
        List<AcctCusInfo> list = this.querySQL("SELECT * FROM CACUSINFO WHERE CUSID = ? AND OSBID = ?",
                new AcctCusInfoRowMapper(), cusId, osbId);
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }
}
