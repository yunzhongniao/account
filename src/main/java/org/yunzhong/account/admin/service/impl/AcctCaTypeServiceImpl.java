package org.yunzhong.account.admin.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.yunzhong.account.admin.dao.AcctCaTypeDao;
import org.yunzhong.account.admin.dao.AcctCusDao;
import org.yunzhong.account.admin.dao.AcctTemplatesDao;
import org.yunzhong.account.admin.model.AcctCaType;
import org.yunzhong.account.admin.service.AcctCaTypeService;
import org.yunzhong.account.common.ServiceException;
import org.yunzhong.account.common.dict.CphErrorCode;

public class AcctCaTypeServiceImpl implements AcctCaTypeService {
    private static final Log log = LogFactory.getLog(AcctCaTypeServiceImpl.class);

    private AcctCaTypeDao caTypeDao;
    private AcctCusDao cusDao;
    private AcctTemplatesDao templateDao;

    public AcctCaTypeDao getCaTypeDao() {
        return caTypeDao;
    }

    public void setCaTypeDao(AcctCaTypeDao caTypeDao) {
        this.caTypeDao = caTypeDao;
    }

    public AcctCusDao getCusDao() {
        return cusDao;
    }

    public void setCusDao(AcctCusDao cusDao) {
        this.cusDao = cusDao;
    }

    public AcctTemplatesDao getTemplateDao() {
        return templateDao;
    }

    public void setTemplateDao(AcctTemplatesDao templateDao) {
        this.templateDao = templateDao;
    }

    @Override
    public List<AcctCaType> getAll(String osbType) {
        return caTypeDao.getAll(osbType);
    }

    @Override
    public void delete(String osbType, String caTypeId) {
        //查询caacctcus，caaccttpl是否使用了此载体
       Long cusCount = cusDao.countCa(osbType, caTypeId);
       if (cusCount != null && cusCount > 0) {
           log.error("acctCaType [" + caTypeId + "] failed to be deleted,It has bean used in acctcus.");
           throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "载体类型在账户中使用，无法删除");
       }
       Long tplCount = templateDao.countCa(osbType, caTypeId);
       if (tplCount != null && tplCount > 0) {
           log.error("acctCaType [" + caTypeId + "] failed to be deleted,It has bean used in accttpl.");
           throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "载体类型在账户模板中使用，无法删除");
       }
        this.caTypeDao.delete(osbType, caTypeId);
    }

    @Override
    public void add(AcctCaType acctCaType) {
        if (acctCaType == null ) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        int row = caTypeDao.add(acctCaType);
        if (row != 1) {
            log.error("catype [" + acctCaType.getCaTypeId() + "] failed to be updated,effected rows [" + row + "].");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "载体类型创建异常");
        }
    }

    @Override
    public void update(AcctCaType acctCaType) {
        if (acctCaType == null) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        int row = caTypeDao.update(acctCaType);
        if (row != 1) {
            log.error("ca type [" + acctCaType.getCaTypeId() + "] failed to be updated,effected rows [" + row + "].");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "载体类型更新异常");
        }
    }

    
}
