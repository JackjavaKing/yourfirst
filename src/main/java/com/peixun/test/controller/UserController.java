package com.peixun.test.controller;

import com.peixun.test.entity.JsonUtil;
import com.peixun.test.entity.User;
import com.peixun.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public JsonUtil login(@RequestBody User user) {
        JsonUtil login = userService.login(user);
        return login;
    }

    @RequestMapping("/regist")
    public JsonUtil regist(@RequestBody User user) {
        JsonUtil registResult = userService.registUser(user);
        return registResult;
    }

}
