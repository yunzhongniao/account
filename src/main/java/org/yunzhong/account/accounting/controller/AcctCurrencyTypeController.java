package org.yunzhong.account.accounting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yunzhong.account.accounting.api.AcctBasicRequestBody;
import org.yunzhong.account.accounting.api.AcctRequest;
import org.yunzhong.account.accounting.api.AcctResponse;
import org.yunzhong.account.accounting.api.AcctResponseBuilder;
import org.yunzhong.account.accounting.service.AcctCurrencyTypeService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("currency/type")
public class AcctCurrencyTypeController {

    @Autowired
    private AcctCurrencyTypeService acctCurrencyTypeService;

    @ApiOperation(value = "币种", notes = "查询币种", httpMethod = "POST")
    @ApiImplicitParam(dataTypeClass = AcctRequest.class, name = "request", value = "requestbody", required = true)
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @PreAuthorize("hasPermission('/list','currency:read')")
    public AcctResponse selectAll(@RequestBody AcctRequest<AcctBasicRequestBody> request) {
        return AcctResponseBuilder.create(acctCurrencyTypeService.selectAll());
    }
}
