package org.yunzhong.account.accounting.dao;

import java.util.List;
import org.yunzhong.account.accounting.model.AcctAccountBookType;

public interface AcctAccountBookTypeMapper {
    int deleteByPrimaryKey(String accountBookType);

    int insert(AcctAccountBookType record);

    AcctAccountBookType selectByPrimaryKey(String accountBookType);

    List<AcctAccountBookType> selectAll();

    int updateByPrimaryKey(AcctAccountBookType record);
}