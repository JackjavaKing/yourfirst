package com.peixun.test.service;

import com.peixun.test.entity.JsonUtil;
import com.peixun.test.entity.User;

public interface UserService {
    /**
     * 用户注册
     *
     * @param user
     * @return 包含状态码state、user、msg
     */
    JsonUtil registUser(User user);

    /**
     * 登录
     *
     * @param user
     * @return @return 包含状态码state、user、msg
     */
    JsonUtil login(User user);

}
