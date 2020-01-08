package org.yunzhong.account.accounting.dao;

import java.util.List;
import org.yunzhong.account.accounting.model.AcctTemplate;

public interface AcctTemplateMapper {
    int deleteByPrimaryKey(Long tplid);

    int insert(AcctTemplate record);

    AcctTemplate selectByPrimaryKey(Long tplid);

    List<AcctTemplate> selectAll();

    int updateByPrimaryKey(AcctTemplate record);
}