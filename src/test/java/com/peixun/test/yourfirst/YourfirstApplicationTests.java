package com.peixun.test.yourfirst;

import com.peixun.test.YourfirstApplication;
import com.peixun.test.entity.JsonUtil;
import com.peixun.test.mapper.BlogMapper;
import com.peixun.test.mapper.UserMapper;
import com.peixun.test.entity.Blog;
import com.peixun.test.entity.User;
import com.peixun.test.service.BlogService;
import com.peixun.test.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = YourfirstApplication.class)
class YourfirstApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private BlogService blogService;

    @Test
    public void testSelect() {
//        List<User> userList = userMapper.selectList(null);
//        userList.forEach(System.out::println);

        List<Blog> blogs = blogMapper.selectList(null);
        blogs.forEach(System.out::println);
    }

    @Test
    public void testUserSevice(){
        User user = new User();
        user.setAccountNum("2569860247@qq.com");
        user.setAccountPassword("123343543241");

        //JsonUtil jsonUtil = userService.registUser(user);
        //System.out.println(jsonUtil);

        JsonUtil login1 = userService.login(user);
        System.out.println(login1);
    }

    @Test
    public void testBlogServic(){
        Blog blog = new Blog();
        blog.setTitle("新青年1111");
        blog.setUserId(1);
        int i = blogService.addBlog(blog);
        System.out.println(i);
    }



}
