package org.yunzhong.account.accounting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yunzhong.account.accounting.dao.AcctAccountBookMapper;
import org.yunzhong.account.accounting.dao.AcctAccountTypeMapper;
import org.yunzhong.account.accounting.model.AcctAccountBook;
import org.yunzhong.account.accounting.model.AcctAccountType;
import org.yunzhong.account.accounting.service.AcctAccountTypeService;
import org.yunzhong.account.common.ServiceException;

@Service
public class AcctAccountTypeServiceImpl implements AcctAccountTypeService {

    @Autowired
    private AcctAccountTypeMapper accountTypeMapper;

    @Autowired
    private AcctAccountBookMapper accountBookMapper;

    @Override
    public List<AcctAccountType> selectByAccountBook(String accountBookId) {
        AcctAccountBook accountBook = accountBookMapper.selectByPrimaryKey(accountBookId);
        if (accountBook == null) {
            throw new ServiceException("账簿不存在");
        }
        return accountTypeMapper.selectByAccountBookType(accountBook.getAccountBookType());
    }
}
