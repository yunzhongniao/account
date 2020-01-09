package org.yunzhong.account.accounting.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.yunzhong.account.accounting.model.AcctCurrencyType;

@Repository
public interface AcctCurrencyTypeMapper {
    int deleteByPrimaryKey(String currtype);

    int insert(AcctCurrencyType record);

    AcctCurrencyType selectByPrimaryKey(String currtype);

    List<AcctCurrencyType> selectAll();

    int updateByPrimaryKey(AcctCurrencyType record);
}