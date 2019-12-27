package org.yunzhong.account.admin.service;

import org.yunzhong.account.admin.model.TrxBook;
import org.yunzhong.account.common.ServiceException;

public interface TrxBookService extends AcctBasicService {
    void add(TrxBook trxBook) throws ServiceException;

}
