package org.yunzhong.account.admin.service;

import java.util.List;

import org.yunzhong.account.admin.model.TrxCat;
import org.yunzhong.account.common.ServiceException;

public interface TrxCatService extends AcctBasicService {

    public List<TrxCat> getAll();

    public void delete(String trxCode) throws ServiceException;

    public void update(TrxCat osb) throws ServiceException;

    public void add(TrxCat osb) throws ServiceException;

}
