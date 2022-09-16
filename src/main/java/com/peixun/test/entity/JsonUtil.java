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
    private int state;//0 成功    1失败
    private Object data;
    private String Msg;//报错异常
}
