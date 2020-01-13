package org.yunzhong.account.accounting.dao;

import org.apache.ibatis.annotations.Param;
import org.yunzhong.account.accounting.model.AcctItem;

public interface AcctItemMapper {
    int deleteByPrimaryKey(@Param("accountBookType") String accountBookType, @Param("itemcode") String itemcode);

    int insert(AcctItem record);

    int insertSelective(AcctItem record);

    AcctItem selectByPrimaryKey(@Param("accountBookType") String accountBookType, @Param("itemcode") String itemcode);

    int updateByPrimaryKeySelective(AcctItem record);

    int updateByPrimaryKey(AcctItem record);
}