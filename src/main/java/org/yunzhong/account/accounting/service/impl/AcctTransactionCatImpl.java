package org.yunzhong.account.accounting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yunzhong.account.accounting.dao.AcctAccountBookMapper;
import org.yunzhong.account.accounting.dao.AcctTransactionCatMapper;
import org.yunzhong.account.accounting.model.AcctAccountBook;
import org.yunzhong.account.accounting.model.AcctTransactionCat;
import org.yunzhong.account.accounting.service.AcctTransactionCatService;
import org.yunzhong.account.common.ServiceException;

@Service
public class AcctTransactionCatImpl implements AcctTransactionCatService {

    @Autowired
    private AcctTransactionCatMapper transactionCatMapper;

    @Autowired
    private AcctAccountBookMapper accountBookMapper;

    @Override
    public List<AcctTransactionCat> listByAccountBookType(String abType) {
        return transactionCatMapper.selectByAccountBookType(abType);
    }

    @Override
    public List<AcctTransactionCat> listByAccountBook(String abId) {
        AcctAccountBook accountBook = accountBookMapper.selectByPrimaryKey(abId);
        if (accountBook == null) {
            throw new ServiceException("账簿不存在");
        }
        return transactionCatMapper.selectByAccountBookType(accountBook.getAccountBookType());
    }
}
