package org.yunzhong.account.accounting.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.yunzhong.account.accounting.model.AcctGenledDetail;

public interface AcctGenledDetailMapper {
    int deleteByPrimaryKey(@Param("accountBookId") String accountBookId, @Param("itemcode") String itemcode, @Param("periodday") String periodday);

    int insert(AcctGenledDetail record);

    AcctGenledDetail selectByPrimaryKey(@Param("accountBookId") String accountBookId, @Param("itemcode") String itemcode, @Param("periodday") String periodday);

    List<AcctGenledDetail> selectAll();

    int updateByPrimaryKey(AcctGenledDetail record);
}