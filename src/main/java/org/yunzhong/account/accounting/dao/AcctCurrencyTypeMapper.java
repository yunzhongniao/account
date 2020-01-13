package org.yunzhong.account.accounting.dao;

import java.util.List;

import org.yunzhong.account.accounting.model.AcctCurrencyType;

public interface AcctCurrencyTypeMapper {
    int deleteByPrimaryKey(String currtype);

    int insert(AcctCurrencyType record);

    int insertSelective(AcctCurrencyType record);

    AcctCurrencyType selectByPrimaryKey(String currtype);

    int updateByPrimaryKeySelective(AcctCurrencyType record);

    int updateByPrimaryKey(AcctCurrencyType record);

    List<AcctCurrencyType> selectAll();
}