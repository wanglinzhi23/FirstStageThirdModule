package com.lagou.login.global.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Result
 *
 * @author wanglinzhi
 * @date 2020/4/22
 */
@Data
@Accessors(chain = true)
public class Result<T> {
    private String code;
    private Boolean success;
    private String msg;
    private T data;
}
