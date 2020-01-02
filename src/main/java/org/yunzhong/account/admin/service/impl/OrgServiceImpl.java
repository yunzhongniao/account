package org.yunzhong.account.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.yunzhong.account.admin.dao.AcctCusDao;
import org.yunzhong.account.admin.dao.AcctENYDao;
import org.yunzhong.account.admin.dao.AcctdiaryDao;
import org.yunzhong.account.admin.dao.CaGenledDao;
import org.yunzhong.account.admin.dao.OrgDao;
import org.yunzhong.account.admin.dao.UserDao;
import org.yunzhong.account.admin.model.Organization;
import org.yunzhong.account.admin.service.OrgService;
import org.yunzhong.account.common.ServiceException;
import org.yunzhong.account.common.dict.CphErrorCode;

public class OrgServiceImpl implements OrgService {
    private static final Log log = LogFactory.getLog(OrgServiceImpl.class);

    private OrgDao orgDao;
    private UserDao userDao;
    private AcctCusDao cusDao;
    private AcctdiaryDao diaryDao;
    private AcctENYDao enyDao;
    private CaGenledDao genledDao;

    public OrgDao getOrgDao() {
        return orgDao;
    }

    public void setOrgDao(OrgDao orgDao) {
        this.orgDao = orgDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public AcctCusDao getCusDao() {
        return cusDao;
    }

    public void setCusDao(AcctCusDao cusDao) {
        this.cusDao = cusDao;
    }

    public AcctdiaryDao getDiaryDao() {
        return diaryDao;
    }

    public void setDiaryDao(AcctdiaryDao diaryDao) {
        this.diaryDao = diaryDao;
    }

    public AcctENYDao getEnyDao() {
        return enyDao;
    }

    public void setEnyDao(AcctENYDao enyDao) {
        this.enyDao = enyDao;
    }

    public CaGenledDao getGenledDao() {
        return genledDao;
    }

    public void setGenledDao(CaGenledDao genledDao) {
        this.genledDao = genledDao;
    }

    @Override
    public List<Organization> getAll() {
        return orgDao.getAll();
    }

    @Override
    @Transactional
    public void delete(String osbId) {
        // app: auappuser,caaccteny
        // org:caacctcus,caacctdiray,caaccteny,cagenled,cagenleddetail
        Organization org = orgDao.getById(osbId);
        if (org == null) {
            log.error("There is no org [" + osbId + "]");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "组织" + osbId + "不存在");
        }
        if (org.getAppInfo() != null) {
            Long appId = org.getAppInfo().getAppId();
            Long userCount = userDao.countApp(appId);
            if (userCount != null && userCount > 0) {
                log.error("appinfo [" + appId + "] failed to be deleted,It has bean used in auappuser.");
                throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "组织机构在用户表中使用，无法删除");
            }
        }
        Long cusCount = cusDao.countOrg(osbId);
        if (cusCount != null && cusCount > 0) {
            log.error("appinfo [" + osbId + "] failed to be deleted,It has bean used in auappuser.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "组织机构在账户中使用，无法删除");
        }
        Long diaryCount = diaryDao.countOrg(osbId);
        if (diaryCount != null && diaryCount > 0) {
            log.error("appinfo [" + osbId + "] failed to be deleted,It has bean used in diary.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "组织机构在日表中使用，无法删除");
        }
        Long enyCount = enyDao.countOrg(osbId);
        if (enyCount != null && enyCount > 0) {
            log.error("appinfo [" + osbId + "] failed to be deleted,It has bean used in eny.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "组织机构在分录明细中使用，无法删除");
        }
        Long genledCount = genledDao.countOrg(osbId);
        if (genledCount != null && genledCount > 0) {
            log.error("appinfo [" + osbId + "] failed to be deleted,It has bean used in genled.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "组织机构在总账中使用，无法删除");
        }
        this.orgDao.deleteApp(osbId);
        this.orgDao.deleteOrg(osbId);
    }

    @Override
    @Transactional
    public void update(Organization org) {
        this.orgDao.updateApp(org.getAppInfo());
        this.orgDao.updateOrg(org);
    }

    @Override
    @Transactional
    public void add(Organization org) {
        if(org.getCrTime() == null){
            org.setCrTime(new Date());
        }
        this.orgDao.addOrg(org);
            if (StringUtils.isEmpty(org.getAppInfo().getOsbId())) {
                org.getAppInfo().setOsbId(org.getOsbId());
            }
            this.orgDao.addApp(org.getAppInfo());
    }

}
