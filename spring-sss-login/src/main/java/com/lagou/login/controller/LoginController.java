package com.lagou.login.controller;

import com.lagou.login.global.entity.Result;
import com.lagou.login.global.entity.ResultBuilder;
import com.lagou.login.global.exceptions.MyErrorCode;
import com.lagou.login.global.MyConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录接口
 *
 * @author wanglinzhi
 * @date 2020/4/22
 */
@Controller
public class LoginController {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletRequest request) {
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            // 登录成功，将登录成功标记设置到session中
            request.getSession().setAttribute(MyConstants.LOGIN_MARK_KEY, true);
            return ResultBuilder.buildResultWithData(null);
        } else {
            return ResultBuilder.buildWithError(MyErrorCode.LOGIN_FAILED);
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public Result logout(HttpServletRequest request) {
        request.getSession().removeAttribute(MyConstants.LOGIN_MARK_KEY);
        return ResultBuilder.buildResultWithData(null);
    }


}
