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

    public JsonUtil() {};

    public JsonUtil(Object data){
        if (data==null){
            state=0;
            Msg="获取信息失败";
        }else {
            state=1;
        }
    }
}
