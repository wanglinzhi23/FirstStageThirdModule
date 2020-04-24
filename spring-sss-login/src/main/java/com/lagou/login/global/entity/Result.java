package com.lagou.login.global.entity;

/**
 * Result
 *
 * @author wanglinzhi
 * @date 2020/4/22
 */
public class Result<T> {
    private String code;
    private Boolean success;
    private String msg;
    private T data;

	public String getCode() {
		return code;
	}

	public Result<T> setCode(String code) {
		this.code = code;
		return this;
	}

	public Boolean getSuccess() {
		return success;
	}

	public Result<T> setSuccess(Boolean success) {
		this.success = success;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public Result<T> setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public T getData() {
		return data;
	}

	public Result<T> setData(T data) {
		this.data = data;
		return this;
	}
}
