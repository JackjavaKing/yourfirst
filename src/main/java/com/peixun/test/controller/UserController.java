package com.peixun.test.controller;

import com.peixun.test.entity.JsonUtil;
import com.peixun.test.entity.User;
import com.peixun.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Component
@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;

    //登录功能控制器
    @RequestMapping("/login")
    public JsonUtil login(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            JsonUtil jsonUtil = new JsonUtil();
            //数据校验信息返回
            jsonUtil.setMsg(errors.getFieldError().getDefaultMessage());
            return jsonUtil;
        } else {
            //登录，并返回回user对象信息
            JsonUtil loginResult = userService.login(user);
            return loginResult;
        }
    }

    //注册功能控制器
    @RequestMapping("/regist")
    public JsonUtil regist(@RequestBody @Valid User user, Errors errors) {

        //数据校验信息返回
        if (errors.hasErrors()) {
            JsonUtil jsonUtil = new JsonUtil();
            System.out.println("errors = " + errors);
            String defaultMessage = errors.getFieldError().getDefaultMessage();
            jsonUtil.setMsg(defaultMessage);
            return jsonUtil;
        } else {

            //注册
            JsonUtil registResult = userService.registUser(user);
            return registResult;
        }
    }

}
