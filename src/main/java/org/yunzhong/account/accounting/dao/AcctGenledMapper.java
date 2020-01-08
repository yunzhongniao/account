package org.yunzhong.account.accounting.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.yunzhong.account.accounting.model.AcctGenled;

public interface AcctGenledMapper {
    int deleteByPrimaryKey(@Param("accountBookId") String accountBookId, @Param("itemcode") String itemcode);

    int insert(AcctGenled record);

    AcctGenled selectByPrimaryKey(@Param("accountBookId") String accountBookId, @Param("itemcode") String itemcode);

    List<AcctGenled> selectAll();

    int updateByPrimaryKey(AcctGenled record);
}