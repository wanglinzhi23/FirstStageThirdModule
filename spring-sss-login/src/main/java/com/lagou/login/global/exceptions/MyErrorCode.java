package com.lagou.login.global.exceptions;

/**
 * MyErrorCode
 *
 * @author 大犬
 * @date 2020/4/9
 */
public enum MyErrorCode {
    /**
     * 返回成功
     */
    SUCCESS("SSS-SUC-000", "请求成功"),

    LOGIN_FAILED("SSS-SYS-001", "登录失败，用户名或密码错误"),

    PERMISSION_DENY("SSS-SYS-002", "没有访问权限"),

    UNKNOWN_ERROR("SSS-SYS-003", "未知异常，请联系管理员"),

    PARAM_ERROR("SSS-SYS-004", "参数 {0} 不可为空"),

    ;


    private String code;
    private String msg;

    MyErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
