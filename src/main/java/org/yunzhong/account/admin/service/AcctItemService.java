package org.yunzhong.account.admin.service;

import java.util.List;

import org.yunzhong.account.admin.model.AcctItem;
import org.yunzhong.account.common.ServiceException;

public interface AcctItemService extends AcctBasicService {

    public List<AcctItem> getAll(String osbType);
    
    public List<AcctItem> getNotAddLevel1Items(String osbType);
    
    public List<AcctItem> getAll(String osbType,Integer itemClass);

    public void delete(String osbType, String itemCode) throws ServiceException;

    public void update(AcctItem osb) throws ServiceException;

    public void add(AcctItem osb) throws ServiceException;
    
    public void addByItemCodes(String osbType, String itemCodes) throws ServiceException;
    
}
