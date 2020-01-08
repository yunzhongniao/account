package org.yunzhong.account.accounting.dao;

import java.util.List;
import org.yunzhong.account.accounting.model.AcctAccountBook;

public interface AcctAccountBookMapper {
    int deleteByPrimaryKey(String accountBookId);

    int insert(AcctAccountBook record);

    AcctAccountBook selectByPrimaryKey(String accountBookId);

    List<AcctAccountBook> selectAll();

    int updateByPrimaryKey(AcctAccountBook record);
}