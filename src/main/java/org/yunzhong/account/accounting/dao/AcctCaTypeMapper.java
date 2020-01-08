package org.yunzhong.account.accounting.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.yunzhong.account.accounting.model.AcctCaType;

public interface AcctCaTypeMapper {
    int deleteByPrimaryKey(@Param("catypeid") String catypeid, @Param("accountBookType") String accountBookType);

    int insert(AcctCaType record);

    AcctCaType selectByPrimaryKey(@Param("catypeid") String catypeid, @Param("accountBookType") String accountBookType);

    List<AcctCaType> selectAll();

    int updateByPrimaryKey(AcctCaType record);
}