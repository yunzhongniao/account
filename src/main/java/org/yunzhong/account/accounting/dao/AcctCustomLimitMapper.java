package org.yunzhong.account.accounting.dao;

import java.util.List;
import org.yunzhong.account.accounting.model.AcctCustomLimit;

public interface AcctCustomLimitMapper {
    int deleteByPrimaryKey(Long limitid);

    int insert(AcctCustomLimit record);

    AcctCustomLimit selectByPrimaryKey(Long limitid);

    List<AcctCustomLimit> selectAll();

    int updateByPrimaryKey(AcctCustomLimit record);
}