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
import org.yunzhong.account.admin.model.AcctType;
import org.yunzhong.account.admin.service.AcctTypeService;
import org.yunzhong.account.common.ServiceException;
import org.yunzhong.account.common.dict.CphErrorCode;

import com.paytechsrv.cph.msg.CphRspMsg;
import com.paytechsrv.cph.msg.RspHead;

@Controller
@RequestMapping("/manage/acct/accttype")
public class AcctTypeController {

    private static final Log log = LogFactory.getLog(OSBController.class);

    @Autowired
    private AcctTypeService typeService;

    @RequestMapping(value = "/{osbType}/list", method = RequestMethod.GET)
    @ResponseBody
    public CphRspMsg getAll(@PathVariable String osbType) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            response.setBody(typeService.getAll(osbType));
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to get type list osbtype [" + osbType + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to get type list osbtype [" + osbType + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

    @RequestMapping(value = "/{osbType}/{acctType}/delete", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg delete(@PathVariable("osbType") String osbType, @PathVariable("acctType") String acctType) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            typeService.delete(osbType, acctType);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to delete acctType [" + osbType + acctType + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to delete acctType [" + osbType + acctType + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg update(@RequestBody AcctType acctType) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            typeService.update(acctType);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to update item [" + acctType.getOsbType() + acctType.getAcctType() + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to update item [" + acctType.getOsbType() + acctType.getAcctType() + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg add(@RequestBody AcctType acctType) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            typeService.add(acctType);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to add typeService [" + acctType.getAcctType() + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to add typeService [" + acctType.getAcctType() + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }
}
