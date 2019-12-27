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
import org.yunzhong.account.admin.model.AcctEFGroup;
import org.yunzhong.account.admin.service.AcctEFService;
import org.yunzhong.account.common.ServiceException;
import org.yunzhong.account.common.dict.CphErrorCode;

import com.paytechsrv.cph.msg.CphRspMsg;
import com.paytechsrv.cph.msg.RspHead;

@Controller
@RequestMapping("/manage/acct/acctef")
public class AcctEFController {

    private static final Log log = LogFactory.getLog(AcctEFController.class);

    @Autowired
    private AcctEFService efService;

    @RequestMapping(value = "/{osbId}/list", method = RequestMethod.GET)
    @ResponseBody
    public CphRspMsg getAll(@PathVariable String osbId) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            response.setBody(efService.getAll(osbId));
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to get entry list osbtype [" + osbId + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to get entry list osbtype [" + osbId + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg delete(@RequestBody AcctEFGroup acctEFGroup) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            efService.delete(acctEFGroup);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to delete acctType [" + acctEFGroup.getOsbType() + acctEFGroup.getTrxCode() + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to delete acctType [" + acctEFGroup.getOsbType() + acctEFGroup.getTrxCode() + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg update(@RequestBody AcctEFGroup acctEFGroup) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            efService.update(acctEFGroup);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to update item [" + acctEFGroup.getOsbType() + acctEFGroup.getTrxCode() + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to update item [" + acctEFGroup.getOsbType() + acctEFGroup.getTrxCode() + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg add(@RequestBody AcctEFGroup acctEFGroup) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            efService.add(acctEFGroup);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to add typeService [" + acctEFGroup.getEfName() + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to add typeService [" + acctEFGroup.getEfName() + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }
}
