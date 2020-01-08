package org.yunzhong.account.accounting.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.yunzhong.account.accounting.model.AcctItem;

public interface AcctItemMapper {
    int deleteByPrimaryKey(@Param("accountBookType") String accountBookType, @Param("itemcode") String itemcode);

    int insert(AcctItem record);

    AcctItem selectByPrimaryKey(@Param("accountBookType") String accountBookType, @Param("itemcode") String itemcode);

    List<AcctItem> selectAll();

    int updateByPrimaryKey(AcctItem record);
}