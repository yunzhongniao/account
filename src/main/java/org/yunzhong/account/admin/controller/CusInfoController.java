package org.yunzhong.account.admin.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yunzhong.account.admin.model.AcctCusInfo;
import org.yunzhong.account.admin.service.AcctCusInfoService;
import org.yunzhong.account.admin.vo.CphRspMsg;
import org.yunzhong.account.admin.vo.RspHead;
import org.yunzhong.account.common.ServiceException;
import org.yunzhong.account.common.dict.CphErrorCode;

@Controller
@RequestMapping("/acct/cus")
public class CusInfoController {
    private static final Log log = LogFactory.getLog(CusInfoController.class);

    @Autowired
    private AcctCusInfoService acctCusInfoService;

    @RequestMapping(value = "/{cusId}/{osbId}/delete", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg delete(@PathVariable("cusId") String cusId, @PathVariable("osbId") String osbId) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            acctCusInfoService.delete(cusId, osbId);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to delete cusInfo [" + cusId + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to delete cusInfo [" + cusId + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg add(@RequestBody AcctCusInfo acctCusInfo) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            acctCusInfoService.add(acctCusInfo);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to add cusInfo [" + acctCusInfo.getCusId() + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to add cusInfo [" + acctCusInfo.getCusId() + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }
    
    @RequestMapping(value = "/{cusId}/{osbId}", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg get(@PathVariable("cusId") String cusId, @PathVariable("osbId") String osbId) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            response.setBody(acctCusInfoService.getOne(cusId, osbId));
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to get cusInfo [" + cusId + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to get cusInfo [" + cusId + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

}
