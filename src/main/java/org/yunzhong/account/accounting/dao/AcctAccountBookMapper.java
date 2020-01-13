package org.yunzhong.account.accounting.dao;

import org.yunzhong.account.accounting.model.AcctAccountBook;

public interface AcctAccountBookMapper {
    int deleteByPrimaryKey(String accountBookId);

    int insert(AcctAccountBook record);

    int insertSelective(AcctAccountBook record);

    AcctAccountBook selectByPrimaryKey(String accountBookId);

    int updateByPrimaryKeySelective(AcctAccountBook record);

    int updateByPrimaryKey(AcctAccountBook record);
}