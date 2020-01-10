package org.yunzhong.account.accounting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yunzhong.account.accounting.dao.AcctTransactionCatMapper;
import org.yunzhong.account.accounting.model.AcctTransactionCat;
import org.yunzhong.account.accounting.service.AcctTransactionCatService;

@Service
public class AcctTransactionCatImpl implements AcctTransactionCatService {

    @Autowired
    private AcctTransactionCatMapper transactionCatMapper;

    @Override
    public List<AcctTransactionCat> listByAccountBookType(String abType) {
        // TODO Auto-generated method stub
        return null;
    }
}
