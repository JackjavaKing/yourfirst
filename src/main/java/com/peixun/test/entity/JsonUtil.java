package com.peixun.test.entity;

import lombok.Data;

/**
 * @program: yourfirst
 * @description:
 * @author: 作者
 * @create: 2022-09-16 18:14
 */
@Data
public class JsonUtil {
    //状态码
    private int state;
    //返回数据
    private Object data;
    //异常信息
    private String Msg;

    //状态码1：成功
    public static final int STATE_OK = 1;

    //状态码0：失败
    static final int STATE_EXCEPT = 0;

    public JsonUtil() {
    }

    public JsonUtil(Object data) {
        if (data == null) {
            state = STATE_EXCEPT;
            Msg = "获取信息失败";
        } else {
            state = STATE_OK;
        }
    }
}
