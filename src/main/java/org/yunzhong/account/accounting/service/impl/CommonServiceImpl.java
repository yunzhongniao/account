package org.yunzhong.account.accounting.service.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yunzhong.account.accounting.dao.CommonMapper;
import org.yunzhong.account.accounting.service.CommonService;
import org.yunzhong.account.common.FuncUtil;
import org.yunzhong.account.common.dict.CphAcctConsts;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonMapper commonMapper;

	@Override
	public String buildAcctno(Date timestamp, boolean cusacct) {
		String flag = CphAcctConsts.ORGTYPE_INNER;
		if (cusacct)
			flag = "0";
		else
			flag = "9";
		String date = FuncUtil.formatTime(timestamp, CphAcctConsts.DATEFMTYM);
		return String.format("%s%s%s", flag, date,
				StringUtils.leftPad(commonMapper.selectSequence("CAACCTNOSEQ"), CphAcctConsts.ACCTNOLEN, "0"));
	}
}
