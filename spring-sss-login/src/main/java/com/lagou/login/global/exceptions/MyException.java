package com.lagou.login.global.exceptions;

/**
 * MyException
 *
 * @author wanglinzhi
 * @date 2020/4/9
 */
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

	public MyErrorCode getMyErrorCode() {
		return myErrorCode;
	}

	public void setMyErrorCode(MyErrorCode myErrorCode) {
		this.myErrorCode = myErrorCode;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}
}
