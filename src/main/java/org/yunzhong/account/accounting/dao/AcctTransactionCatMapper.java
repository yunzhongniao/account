package org.yunzhong.account.accounting.dao;

import java.util.List;
import org.yunzhong.account.accounting.model.AcctTransactionCat;

public interface AcctTransactionCatMapper {
    int deleteByPrimaryKey(String trxcode);

    int insert(AcctTransactionCat record);

    AcctTransactionCat selectByPrimaryKey(String trxcode);

    List<AcctTransactionCat> selectAll();

    int updateByPrimaryKey(AcctTransactionCat record);
}