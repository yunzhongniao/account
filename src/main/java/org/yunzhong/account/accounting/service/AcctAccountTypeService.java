package org.yunzhong.account.accounting.service;

import java.util.List;

import org.yunzhong.account.accounting.model.AcctAccountType;

public interface AcctAccountTypeService {

    List<AcctAccountType> selectByAccountBook(String accountBookId);
}
