package org.yunzhong.account.accounting.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yunzhong.account.accounting.api.AcctBasicRequestBody;
import org.yunzhong.account.accounting.api.AcctRequest;
import org.yunzhong.account.accounting.api.AcctResponse;
import org.yunzhong.account.accounting.api.AcctResponseBuilder;
import org.yunzhong.account.accounting.model.AcctCurrencyType;
import org.yunzhong.account.accounting.service.AcctCurrencyTypeService;
import org.yunzhong.account.accounting.vo.AcctCurrencyTypeVo;
import org.yunzhong.account.common.ServiceException;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("currency/type")
public class AcctCurrencyTypeController {

    @Autowired
    private AcctCurrencyTypeService acctCurrencyTypeService;

    @ApiOperation(value = "币种", notes = "查询币种", httpMethod = "POST")
    @ApiImplicitParam(dataType = "AcctRequest«AcctBasicRequestBody»", name = "request", value = "requestbody", required = true)
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public AcctResponse selectAll(@RequestBody AcctRequest<AcctBasicRequestBody> request) {
        return AcctResponseBuilder.create(acctCurrencyTypeService.selectAll());
    }

    @ApiOperation(value = "币种", notes = "新建币种", httpMethod = "POST")
    @ApiImplicitParam(dataType = "AcctRequest«AcctCurrencyTypeVo»", name = "request", value = "requestbody", required = true)
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public AcctResponse create(@RequestBody AcctRequest<AcctCurrencyTypeVo> request) {
        AcctCurrencyTypeVo body = request.getBody();
        if (body == null) {
            throw new ServiceException("param error");
        }
        AcctCurrencyType currency = new AcctCurrencyType();
        BeanUtils.copyProperties(body, currency);
        acctCurrencyTypeService.create(currency);
        return AcctResponseBuilder.create(null);
    }
}
