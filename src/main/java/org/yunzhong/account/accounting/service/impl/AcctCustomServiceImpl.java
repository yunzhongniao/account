package org.yunzhong.account.accounting.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.yunzhong.account.accounting.api.AcctCustomCreateRequest;
import org.yunzhong.account.accounting.dao.AcctAccountBookMapper;
import org.yunzhong.account.accounting.dao.AcctAccountBookTypeMapper;
import org.yunzhong.account.accounting.dao.AcctAccountTypeMapper;
import org.yunzhong.account.accounting.dao.AcctCaTypeMapper;
import org.yunzhong.account.accounting.dao.AcctCustomMapper;
import org.yunzhong.account.accounting.dao.AcctItemMapper;
import org.yunzhong.account.accounting.dao.AcctTemplateMapper;
import org.yunzhong.account.accounting.model.AcctAccountBook;
import org.yunzhong.account.accounting.model.AcctAccountType;
import org.yunzhong.account.accounting.model.AcctCaType;
import org.yunzhong.account.accounting.model.AcctCreateLogicTemplate;
import org.yunzhong.account.accounting.model.AcctItem;
import org.yunzhong.account.accounting.model.AcctTemplate;
import org.yunzhong.account.accounting.service.AcctCustomService;
import org.yunzhong.account.accounting.service.CommonService;
import org.yunzhong.account.common.ServiceException;

@Service
public class AcctCustomServiceImpl implements AcctCustomService {

	@Autowired
	private AcctCustomMapper customMapper;

	@Autowired
	private AcctAccountBookTypeMapper accountBookTypeMapper;

	@Autowired
	private AcctAccountBookMapper accountBookMapper;

	@Autowired
	private AcctCaTypeMapper caTypeMapper;

	@Autowired
	private AcctAccountTypeMapper accountTypeMapper;

	@Autowired
	private AcctTemplateMapper templateMapper;

	@Autowired
	private AcctItemMapper itemMapper;

	@Autowired
	private CommonService commonService;

	@Override
	public void createCustom(String user, AcctCustomCreateRequest request) {
		AcctAccountBook accountBook = accountBookMapper.selectByPrimaryKey(request.getAccountBookId());
		if (accountBook == null) {
			throw new ServiceException("账簿不存在");
		}
		AcctCaType caType = caTypeMapper.selectByPrimaryKey(request.getAcctCaType(), accountBook.getAccountBookType());
		if (caType == null) {
			throw new ServiceException("无法找到账簿的载体类型");
		}
		AcctAccountType accountType = null;
		if (StringUtils.isEmpty(request.getAcctType())) {
			accountType = accountTypeMapper.selectByPrimaryKey(accountBook.getAccountBookType(), request.getAcctType());
			if (accountType == null) {
				throw new ServiceException("无法找到账户类型");
			}
		}
		List<AcctTemplate> templates = null;
		if (accountType != null) {
			templates = templateMapper.select(accountBook.getAccountBookType(), caType.getCatypeid(),
					accountType.getAccttype());
		} else {
			templates = templateMapper.select(accountBook.getAccountBookType(), caType.getCatypeid(), null);
		}
		if (CollectionUtils.isEmpty(templates)) {
			throw new ServiceException("找不到账户模板");
		}
		// TODO
	}

	protected List<AcctCreateLogicTemplate> initLogicTpl(List<AcctTemplate> tpls, Date timestamp,
			String accountBookType, boolean cusacct) {
		List<AcctCreateLogicTemplate> logictplls = new ArrayList<AcctCreateLogicTemplate>();
		List<AcctItem> items = itemMapper.selectByAccountBookType(accountBookType);
		Map<String, AcctItem> itemMap = items.stream().collect(Collectors.toMap(AcctItem::getItemcode, item -> item));
		for (AcctTemplate tpl : tpls) {
			AcctItem item = itemMap.get(tpl.getItemcode());
			if (item == null) {
				throw new ServiceException("账户创建模板所属科目不存在:" + tpl.getAccountBookType() + " " + tpl.getItemcode());
			}
			AcctCreateLogicTemplate logictpl = new AcctCreateLogicTemplate();
			logictpl.setItem(item);
			logictpl.setTemplate(tpl);
			logictpl.setAccountNo(commonService.buildAcctno(timestamp, cusacct));
			logictplls.add(logictpl);
		}
		return logictplls;
	}
}
