package org.yunzhong.account.admin.service;

import java.util.List;

import org.yunzhong.account.admin.model.Organization;

public interface OrgService {

    List<Organization> getAll();

    void delete(String osbId);

    void update(Organization org);

    void add(Organization org);

}
