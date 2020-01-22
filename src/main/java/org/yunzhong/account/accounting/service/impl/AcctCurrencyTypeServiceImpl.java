package org.yunzhong.account.accounting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yunzhong.account.accounting.dao.AcctCurrencyTypeMapper;
import org.yunzhong.account.accounting.model.AcctCurrencyType;
import org.yunzhong.account.accounting.service.AcctCurrencyTypeService;

@Service
public class AcctCurrencyTypeServiceImpl implements AcctCurrencyTypeService {

    @Autowired
    private AcctCurrencyTypeMapper currencyTypeMapper;

    @Override
    public List<AcctCurrencyType> selectAll() {
        return currencyTypeMapper.selectAll();
    }

    @Override
    public void create(AcctCurrencyType currency) {
        currencyTypeMapper.insert(currency);
    }

}
