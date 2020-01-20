package org.yunzhong.account.accounting.dao;

import org.apache.ibatis.annotations.Param;
import org.yunzhong.account.accounting.model.SysUser;

public interface SysUserMapper {
	int deleteByPrimaryKey(Long id);

	int insert(SysUser record);

	int insertSelective(SysUser record);

	SysUser selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SysUser record);

	int updateByPrimaryKey(SysUser record);

	SysUser selectByUsername(@Param("username") String username);
}