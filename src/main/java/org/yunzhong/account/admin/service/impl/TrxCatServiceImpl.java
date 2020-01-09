package org.yunzhong.account.admin.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.yunzhong.account.admin.dao.AcctEFDao;
import org.yunzhong.account.admin.dao.AcctENYDao;
import org.yunzhong.account.admin.dao.TrxCatDao;
import org.yunzhong.account.admin.model.TrxCat;
import org.yunzhong.account.admin.service.TrxCatService;
import org.yunzhong.account.common.ServiceException;
import org.yunzhong.account.common.dict.CphErrorCode;

@Service
public class TrxCatServiceImpl implements TrxCatService {
    private static final Log log = LogFactory.getLog(TrxCatServiceImpl.class);

    private TrxCatDao trxDao;
    private AcctEFDao efDao;
    private AcctENYDao enyDao;

    public TrxCatDao getTrxDao() {
        return trxDao;
    }

    public void setTrxDao(TrxCatDao trxDao) {
        this.trxDao = trxDao;
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

    @Override
    public List<TrxCat> getAll() {
        return trxDao.getAll();
    }

    @Override
    public void delete(String trxCode) throws ServiceException {
        // acctef,accteny
        Long efCount = efDao.countTrx(trxCode);
        if (efCount != null && efCount > 0) {
            log.error("trxcat [" + trxCode + "] failed to be deleted,It has bean used in acctcus.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "交易类型在分录规则中使用，无法删除");
        }
        Long enyCount = enyDao.countTrx(trxCode);
        if (enyCount != null && enyCount > 0) {
            log.error("trxcat [" + trxCode + "] failed to be deleted,It has bean used in accttpl.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "交易类型在分录明细中使用，无法删除");
        }
        trxDao.delete(trxCode);
    }

    @Override
    public void update(TrxCat trxCat) throws ServiceException {
        if (trxCat == null) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        int row = trxDao.update(trxCat);
        if (row != 1) {
            log.error("trxcat [" + trxCat.getTrxCode() + "] failed to be updated,effected rows [" + row + "].");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "交易类型更新异常");
        }
    }

    @Override
    public void add(TrxCat trxCat) throws ServiceException {
        if (trxCat == null) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        int row = trxDao.add(trxCat);
        if (row != 1) {
            log.error("trxcat [" + trxCat.getTrxCode() + "] failed to add,effected rows [" + row + "].");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "交易类型插入异常");
        }

    }

}
