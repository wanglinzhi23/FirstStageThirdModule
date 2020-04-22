package com.lagou.login.controller.advices;

import com.lagou.login.global.entity.Result;
import com.lagou.login.global.entity.ResultBuilder;
import com.lagou.login.global.exceptions.MyErrorCode;
import com.lagou.login.global.exceptions.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常获取
 *
 * @author wanglinzhi
 * @date 2020/4/22
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result myException(MyException myException) {
        MyErrorCode myErrorCode = myException.getMyErrorCode();
        Object[] params = myException.getParams();
        return ResultBuilder.buildWithError(myErrorCode,params);
    }


    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Result otherException(Throwable throwable) {
        logger.error("发生未知异常", throwable);
        return ResultBuilder.buildWithError(MyErrorCode.UNKNOWN_ERROR);
    }


}
