package org.yunzhong.account.accounting.dao;

import java.util.List;

import org.yunzhong.account.accounting.model.SysPermission;

public interface SysPermissionMapper {
	int deleteByPrimaryKey(Long id);

	int insert(SysPermission record);

	int insertSelective(SysPermission record);

	SysPermission selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SysPermission record);

	int updateByPrimaryKey(SysPermission record);

	List<SysPermission> selectByUser(Long userId);
}