package org.yunzhong.account.admin.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.yunzhong.account.admin.dao.AcctCusDao;
import org.yunzhong.account.admin.dao.AcctdiaryDao;
import org.yunzhong.account.admin.dao.CurrTypeDao;
import org.yunzhong.account.admin.model.CurrType;
import org.yunzhong.account.admin.service.CurrTypeService;
import org.yunzhong.account.common.ServiceException;
import org.yunzhong.account.common.dict.CphErrorCode;

public class CurrTypeServiceImpl implements CurrTypeService {
    private static final Log log = LogFactory.getLog(CurrTypeServiceImpl.class);
    
    private CurrTypeDao currTypeDao;
    
    private AcctCusDao acctCusDao;
    
    private AcctdiaryDao acctdiaryDao;
    
    public CurrTypeDao getCurrTypeDao() {
        return currTypeDao;
    }

    public void setCurrTypeDao(CurrTypeDao currTypeDao) {
        this.currTypeDao = currTypeDao;
    }
    
    public AcctCusDao getAcctCusDao() {
        return acctCusDao;
    }

    public void setAcctCusDao(AcctCusDao acctCusDao) {
        this.acctCusDao = acctCusDao;
    }

    public AcctdiaryDao getAcctdiaryDao() {
        return acctdiaryDao;
    }

    public void setAcctdiaryDao(AcctdiaryDao acctdiaryDao) {
        this.acctdiaryDao = acctdiaryDao;
    }

    @Override
    public List<CurrType> getAll() {
        return currTypeDao.getAll();
    }

    @Override
    public void delete(String currType) throws ServiceException {
        //校验acctcus，caacctdiary
        Long cusCount = acctCusDao.countCurrType(currType);
        if (cusCount != null && cusCount > 0) {
            log.error("currType [" + currType + "] failed to be deleted,It has bean used in acctcus.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "币种在账户中使用，无法删除");
        }
        Long diaryCount = acctdiaryDao.countCurrType(currType);
        if (diaryCount != null && diaryCount > 0) {
            log.error("currType [" + currType + "] failed to be deleted,It has bean used in diary.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "币种在账户日表中使用，无法删除");
        }
        currTypeDao.delete(currType);
    }

    @Override
    public void update(CurrType currType) throws ServiceException {
        if (currType == null) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        int row = currTypeDao.update(currType);
        if (row != 1) {
            log.error("CurrName [" + currType.getCurrName() + "] failed to be updated,effected rows [" + row + "].");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "币种更新异常");
        }
    }

    @Override
    public void add(CurrType currType) throws ServiceException {
        if (currType == null ) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        int row = currTypeDao.add(currType);
        if (row != 1) {
            log.error("CurrName [" + currType.getCurrName() + "] failed to be add,effected rows [" + row + "].");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "币种创建异常");
        }
    }
    
}
