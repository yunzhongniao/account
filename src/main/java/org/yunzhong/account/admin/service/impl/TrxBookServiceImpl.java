package org.yunzhong.account.admin.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.yunzhong.account.admin.dao.TrxBookDao;
import org.yunzhong.account.admin.model.TrxBook;
import org.yunzhong.account.admin.service.TrxBookService;
import org.yunzhong.account.common.ServiceException;
import org.yunzhong.account.common.dict.CphErrorCode;

public class TrxBookServiceImpl implements TrxBookService {
    private static final Log log = LogFactory.getLog(TrxBookServiceImpl.class);

    private TrxBookDao trxBookDao;

    public TrxBookDao getTrxDao() {
        return trxBookDao;
    }

    public void setTrxDao(TrxBookDao trxDao) {
        this.trxBookDao = trxDao;
    }

    @Override
    public void add(TrxBook trxBook) throws ServiceException {
        if (trxBook == null) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        int row = trxBookDao.add(trxBook);
        if (row != 1) {
            log.error("trxbook [" + trxBook.getTrxId() + "] failed to add,effected rows [" + row + "].");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "流水账插入异常");
        }

    }
}
