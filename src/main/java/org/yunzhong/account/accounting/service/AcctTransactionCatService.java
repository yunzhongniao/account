package org.yunzhong.account.accounting.service;

import java.util.List;

import org.yunzhong.account.accounting.model.AcctTransactionCat;

public interface AcctTransactionCatService {

    List<AcctTransactionCat> listByAccountBookType(String abType);

    List<AcctTransactionCat> listByAccountBook(String abId);
}
