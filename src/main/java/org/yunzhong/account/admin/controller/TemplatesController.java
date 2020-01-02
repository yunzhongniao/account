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
import org.yunzhong.account.admin.model.AcctTemplate;
import org.yunzhong.account.admin.model.PageSearch;
import org.yunzhong.account.admin.service.AcctTemplatesService;
import org.yunzhong.account.admin.vo.CphRspMsg;
import org.yunzhong.account.admin.vo.RspHead;
import org.yunzhong.account.common.ServiceException;
import org.yunzhong.account.common.dict.CphErrorCode;

/**
 * @author yunzhong
 *
 */
@Controller
@RequestMapping("/manage/acct/template")
public class TemplatesController {
    private static final Log log = LogFactory.getLog(TemplatesController.class);

    @Autowired
    private AcctTemplatesService templateService;

    @RequestMapping(value = "search", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg search(@RequestBody PageSearch pageSearch) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            response.setBody(
                    templateService.search(pageSearch.getOsbType(), pageSearch.getPage(), pageSearch.getPageSize()));
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to search template page info", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to search template page info", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

    @RequestMapping(value = "/{tplId}/delete", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg delete(@PathVariable("tplId") Long tplId) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            templateService.delete(tplId);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to delete template [" + tplId + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to delete template [" + tplId + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg update(@RequestBody AcctTemplate template) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            templateService.update(template);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to update template [" + template.getTplName() + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to delete template [" + template.getTplName() + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg add(@RequestBody AcctTemplate template) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            templateService.add(template);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to add template [" + template + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to add template [" + template + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

}
