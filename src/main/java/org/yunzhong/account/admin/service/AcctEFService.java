package org.yunzhong.account.admin.service;

import java.util.List;

import org.yunzhong.account.admin.model.AcctEF;
import org.yunzhong.account.admin.model.AcctEFGroup;

public interface AcctEFService extends AcctBasicService {

    List<AcctEF> getAll(String osbType);

    void delete(AcctEFGroup acctEF);

    void update(AcctEFGroup acctEF);

    void add(AcctEFGroup acctEFGroup);

}
