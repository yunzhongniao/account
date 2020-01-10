package org.yunzhong.account.accounting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yunzhong.account.accounting.api.AcctResponse;
import org.yunzhong.account.accounting.api.AcctResponseBuilder;
import org.yunzhong.account.accounting.service.AcctCurrencyTypeService;

@RestController
@RequestMapping("currency/type")
public class AcctCurrencyTypeController {

    @Autowired
    private AcctCurrencyTypeService acctCurrencyTypeService;

    @RequestMapping()
    public AcctResponse selectAll() {
        return AcctResponseBuilder.create(acctCurrencyTypeService.selectAll());
    }
}