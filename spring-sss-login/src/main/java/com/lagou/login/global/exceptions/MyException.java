package com.lagou.login.global.exceptions;

import lombok.Data;

/**
 * MyException
 *
 * @author 大犬
 * @date 2020/4/9
 */
@Data
public class MyException extends RuntimeException {

    private MyErrorCode myErrorCode;
    private Object[] params;

    public MyException(MyErrorCode myErrorCode) {
        this.myErrorCode = myErrorCode;
    }

    public MyException(MyErrorCode myErrorCode, Object... params) {
        this.myErrorCode = myErrorCode;
        this.params = params;
    }

}
