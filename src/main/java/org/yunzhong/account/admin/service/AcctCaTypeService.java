package org.yunzhong.account.admin.service;

import java.util.List;

import org.yunzhong.account.admin.model.AcctCaType;

public interface AcctCaTypeService extends AcctBasicService {

    List<AcctCaType> getAll(String osbType);

    void delete(String osbType, String caTypeId);

    void add(AcctCaType acctCaType);

    void update(AcctCaType acctCaType);

}
