package com.lagou.login.controller.interceptors;

import com.alibaba.fastjson.JSONObject;
import com.lagou.login.global.entity.Result;
import com.lagou.login.global.entity.ResultBuilder;
import com.lagou.login.global.exceptions.MyErrorCode;
import com.lagou.login.global.MyConstants;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

/**
 * 资源校验拦截器
 *
 * @author wanglinzhi
 * @date 2020/4/22
 */

public class ResourceInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        response.setHeader("content-type", "text/html;charset=UTF-8");
        Object value = request.getSession().getAttribute(MyConstants.LOGIN_MARK_KEY);
        if (value == null) {
            Result result = ResultBuilder.buildWithError(MyErrorCode.PERMISSION_DENY);
            response.getWriter().write(JSONObject.toJSONString(result));
            return false;
        }

        return true;
    }
}
