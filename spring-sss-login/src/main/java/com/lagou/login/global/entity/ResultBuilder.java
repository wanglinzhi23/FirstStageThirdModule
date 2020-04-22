package com.lagou.login.global.entity;

import com.lagou.login.global.exceptions.MyErrorCode;

import java.text.MessageFormat;

/**
 * ResultBuilder
 *
 * @author wanglinzhi
 * @date 2020/4/22
 */
public class ResultBuilder {


    private ResultBuilder() {

    }

    public static <T> Result<T> buildResultWithData(T t) {
        return new Result<T>()
                .setSuccess(true)
                .setData(t)
                .setCode(MyErrorCode.SUCCESS.getCode())
                .setMsg(MyErrorCode.SUCCESS.getMsg());
    }

    public static Result buildWithError(MyErrorCode errorCode) {
        return new Result()
                .setSuccess(false)
                .setCode(errorCode.getCode())
                .setMsg(errorCode.getMsg());
    }

    public static Result buildWithError(MyErrorCode errorCode, Object... params) {
        if (params == null || params.length == 0) {
            return buildWithError(errorCode);
        }
        return new Result()
                .setSuccess(false)
                .setCode(errorCode.getCode())
                .setMsg(MessageFormat.format(errorCode.getMsg(), params));
    }


}
