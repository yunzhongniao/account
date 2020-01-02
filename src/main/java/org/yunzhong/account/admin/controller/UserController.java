package org.yunzhong.account.admin.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yunzhong.account.admin.model.AppUser;
import org.yunzhong.account.admin.model.PageSearch;
import org.yunzhong.account.admin.service.UserService;
import org.yunzhong.account.admin.vo.CphRspMsg;
import org.yunzhong.account.admin.vo.RspHead;
import org.yunzhong.account.common.Md5Encoder;
import org.yunzhong.account.common.ServiceException;
import org.yunzhong.account.common.dict.CphErrorCode;

@Controller
@RequestMapping("/manage/acct/user")
public class UserController {
    private static final Log log = LogFactory.getLog(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "check", method = RequestMethod.POST)
    public @ResponseBody CphRspMsg check(@RequestBody AppUser user) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            user.setUserPwd(Md5Encoder.encode(user.getUserPwd()));
            AppUser checkUser = userService.checkUser(user);
            if (checkUser == null) {
                response.getHead().setRetcode(CphErrorCode.ERR_CODE_PWD);
            } else {
                response.setBody(checkUser);
                response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
            }
        } catch (ServiceException e) {
            log.error("Failed to get osb list", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to get osb list", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg search(@RequestBody PageSearch condition) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            response.setBody(userService.search(condition.getAppId(), condition.getPage(), condition.getPageSize()));
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to search users", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to search users", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

    @RequestMapping(value = "/{appId}/{userId}/delete", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg delete(@PathVariable("appId") Long appId, @PathVariable("userId") String userId) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            userService.delete(appId, userId);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to delete osbtype [" + appId + userId + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to delete osbtype [" + appId + userId + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg update(@RequestBody AppUser user) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            if (!StringUtils.isEmpty(user.getUserPwd())) {
                user.setUserPwd(Md5Encoder.encode(user.getUserPwd()));
            }
            userService.update(user);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to update user [" + user.getUserId() + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to update osbtype [" + user.getUserId() + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg add(@RequestBody AppUser user) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            user.setUserPwd(Md5Encoder.encode(user.getUserPwd()));
            userService.add(user);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to add user [" + user.getUserId() + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to add user [" + user.getUserId() + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

    @RequestMapping(value = "/append/role", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg appendRole(@RequestBody AppUser user) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            userService.appendRole(user);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to append user [" + user.getUserId() + "] role", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to append user [" + user.getUserId() + "] role", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

    @RequestMapping(value = "/remove/role", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg removeRole(@RequestBody AppUser user) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            userService.removeRole(user);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to remove user [" + user.getUserId() + "] role", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to remove user [" + user.getUserId() + "] role", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }
}
