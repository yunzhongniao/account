package org.yunzhong.account.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.CollectionUtils;
import org.yunzhong.account.admin.model.AppInfo;
import org.yunzhong.account.admin.model.Organization;

public class OrgDao extends AcctBasicDao<Organization> {

    public static class OrganizationRowMapper implements RowMapper<Organization> {

        @Override
        public Organization mapRow(ResultSet rs, int rowNum) throws SQLException {
            Organization org = new Organization();
            org.setOsbId(rs.getString("OSBID"));
            org.setSbName(rs.getString("SBNAME"));
            org.setState(rs.getInt("STATE"));
            org.setCrTime(rs.getDate("CRTIME"));
            org.setCrUser(rs.getString("CRUSER"));
            org.setShutupTime(rs.getDate("SHUTUPTIME"));
            org.setShutupUser(rs.getString("SHUTUPUSER"));
            org.setShutdownTime(rs.getDate("SHUTDOWNTIME"));
            org.setShutdownUser(rs.getString("SHUTDOWNUSER"));
            org.setOsbType(rs.getString("OSBTYPE"));
            AppInfo app = new AppInfo();
            app.setAppId(rs.getLong("APPID"));
            app.setAppName(rs.getString("APPNAME"));
            app.setOsbId(org.getOsbId());
            org.setAppInfo(app);
            return org;
        }

    }
    
    public static class OsbRowMapper implements RowMapper<Organization> {

        @Override
        public Organization mapRow(ResultSet rs, int rowNum) throws SQLException {
            Organization org = new Organization();
            org.setOsbId(rs.getString("OSBID"));
            org.setSbName(rs.getString("SBNAME"));
            org.setState(rs.getInt("STATE"));
            org.setCrTime(rs.getDate("CRTIME"));
            org.setCrUser(rs.getString("CRUSER"));
            org.setShutupTime(rs.getDate("SHUTUPTIME"));
            org.setShutupUser(rs.getString("SHUTUPUSER"));
            org.setShutdownTime(rs.getDate("SHUTDOWNTIME"));
            org.setShutdownUser(rs.getString("SHUTDOWNUSER"));
            org.setOsbType(rs.getString("OSBTYPE"));
            return org;
        }

    }
    
    public List<Organization> getByOSBType(String osbType) {
        String sql = "SELECT * FROM CAACCTOSB WHERE OSBTYPE = ?";
        return this.querySQL(sql, new OsbRowMapper(), osbType);
    }

    public List<Organization> getAll() {
        String sql = "SELECT osb.*, app.APPID,app.APPNAME FROM caacctosb as osb INNER JOIN auappinfo as app ON osb.OSBID = app.OSBID";
        return this.querySQL(sql, new OrganizationRowMapper());
    }

    public Organization getById(String osbId) {
        String sql = "SELECT osb.*, app.APPID,app.APPNAME FROM caacctosb as osb INNER JOIN auappinfo as app ON osb.OSBID = app.OSBID WHERE osb.OSBID = ?";
        List<Organization> orgs = this.querySQL(sql, new OrganizationRowMapper(), osbId);
        if (!CollectionUtils.isEmpty(orgs)) {
            return orgs.get(0);
        } else {
            return null;
        }
    }

    public int deleteOrg(String osbId) {
        String sql = "DELETE FROM caacctosb WHERE OSBID = ?";
        return this.updateSQL(sql, osbId);
    }

    public int deleteApp(String osbId) {
        String sql = "DELETE FROM auappinfo WHERE OSBID = ?";
        return this.updateSQL(sql, osbId);
    }

    public int updateOrg(Organization org) {
        String sql = "UPDATE caacctosb SET SBNAME = ?,STATE=?,SHUTDOWNTIME=?,SHUTDOWNUSER=? WHERE OSBID = ?";
        return this.updateSQL(sql, org.getSbName(), org.getState(),org.getShutdownTime(), org.getShutdownUser(), org.getOsbId());
    }

    public int updateApp(AppInfo app) {
        String sql = "UPDATE auappinfo SET APPNAME = ? where APPID=?";
        return this.updateSQL(sql, app.getAppName(), app.getAppId());
    }

    public int addOrg(Organization org) {
        String sql = "INSERT INTO caacctosb(OSBID, SBNAME,STATE,CRTIME,CRUSER,SHUTUPTIME,SHUTUPUSER,OSBTYPE) VALUES(?,?,?,?,?,?,?,?)";
        return this.updateSQL(sql, org.getOsbId(), org.getSbName(), org.getState(), org.getCrTime(), org.getCrUser(),
                org.getShutupTime(), org.getShutupUser(), org.getOsbType());
    }

    public int addApp(AppInfo app) {
        String sql = "INSERT INTO auappinfo(APPID, APPNAME,OSBID) VALUES(?,?,?)";
        return this.updateSQL(sql, app.getAppId(), app.getAppName(), app.getOsbId());
    }
}
