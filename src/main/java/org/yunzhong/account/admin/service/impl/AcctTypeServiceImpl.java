package org.yunzhong.account.admin.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.yunzhong.account.admin.dao.AcctCusDao;
import org.yunzhong.account.admin.dao.AcctEFDao;
import org.yunzhong.account.admin.dao.AcctENYDao;
import org.yunzhong.account.admin.dao.AcctTemplatesDao;
import org.yunzhong.account.admin.dao.AcctTypeDao;
import org.yunzhong.account.admin.model.AcctType;
import org.yunzhong.account.admin.service.AcctTypeService;
import org.yunzhong.account.common.ServiceException;
import org.yunzhong.account.common.dict.CphErrorCode;

public class AcctTypeServiceImpl implements AcctTypeService {
    private static final Log log = LogFactory.getLog(AcctTypeServiceImpl.class);

    private AcctTypeDao typeDao;
    private AcctCusDao cusDao;
    private AcctEFDao efDao;
    private AcctENYDao enyDao;
    private AcctTemplatesDao templateDao;

    public AcctCusDao getCusDao() {
        return cusDao;
    }

    public void setCusDao(AcctCusDao cusDao) {
        this.cusDao = cusDao;
    }

    public AcctEFDao getEfDao() {
        return efDao;
    }

    public void setEfDao(AcctEFDao efDao) {
        this.efDao = efDao;
    }

    public AcctENYDao getEnyDao() {
        return enyDao;
    }

    public void setEnyDao(AcctENYDao enyDao) {
        this.enyDao = enyDao;
    }

    public AcctTemplatesDao getTemplateDao() {
        return templateDao;
    }

    public void setTemplateDao(AcctTemplatesDao templateDao) {
        this.templateDao = templateDao;
    }

    @Override
    public List<AcctType> getAll(String osbType) {
        return typeDao.getAll(osbType);
    }

    @Override
    public void delete(String osbType, String acctType) throws ServiceException {
        // caacctcus,caacctef,caaccteny，caaccttpl 需要验证.
        Long cusCount = cusDao.count(osbType, acctType);
        if (cusCount != null && cusCount > 0) {
            log.error("acctType [" + acctType + "] failed to be deleted,It has bean used in acctcus.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "账户类型在账户中使用，无法删除");
        }
        Long efCount = efDao.count(osbType, acctType);
        if (efCount != null && efCount > 0) {
            log.error("acctType [" + acctType + "] failed to be deleted,It has bean used in acctef.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "账户类型在分录规则中使用，无法删除");
        }
        Long enyCount = enyDao.count(osbType, acctType);
        if (enyCount != null && enyCount > 0) {
            log.error("acctType [" + acctType + "] failed to be deleted,It has bean used in accteny.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "账户类型在分录明细使用，无法删除");
        }
        Long tplCount = templateDao.count(osbType, acctType);
        if (tplCount != null && tplCount > 0) {
            log.error("acctType [" + acctType + "] failed to be deleted,It has bean used in template.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "账户类型在模板中使用，无法删除");
        }
        this.typeDao.delete(osbType, acctType);
    }

    @Override
    public void update(AcctType acctType) throws ServiceException {
        if (acctType == null) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        int row = typeDao.update(acctType);
        if (row != 1) {
            log.error("template [" + acctType.getTypeName()+ "] failed to be updated,effected rows [" + row + "].");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "账号类型更新异常");
        }
    }

    @Override
    public void add(AcctType acctType) throws ServiceException {
        if (acctType == null ) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        int row = typeDao.add(acctType);
        if (row != 1) {
            log.error("template [" + acctType.getTypeName() + "] failed to be updated,effected rows [" + row + "].");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "账号类型创建异常");
        }
    }

    public AcctTypeDao getTypeDao() {
        return typeDao;
    }

    public void setTypeDao(AcctTypeDao typeDao) {
        this.typeDao = typeDao;
    }
}
