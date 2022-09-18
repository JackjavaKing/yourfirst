package com.peixun.test.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @program: cloud
 * @description:
 * @author: 作者
 * @create: 2022-06-14 17:55
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


//配置用户信息
    //用法
    /*
1.通过java的方式 配置用户名/密码
2.在这里完成获得数据库中的用户信息
3.密码一定要加密
4.登录认证
    */



    //配置过滤的
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**","/js/**","/pics/**");
    }

    //配置拦截器模式（哪些资源需要验证，）
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/BlogIndex/AllBlog", "/BlogIndex/SelectBlog").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().and().httpBasic();




        }
}
