package com.peixun.test.controller;

import com.peixun.test.entity.Blog;
import com.peixun.test.entity.JsonUtil;
import com.peixun.test.entity.User;
import com.peixun.test.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Component
@RestController
@RequestMapping("/BlogIndex")
public class BlogController {

    private static final int STATE_OK = 1;   //状态码：成功

    private static final int STATE_EXCEPTION = 0;  //状态码：失败

    private static final int NOT_ALTER = 0;        // 没发生改变


    @Autowired
    private BlogService blogService;

    @RequestMapping("/myBlog")
    public JsonUtil myBlog(@RequestBody User user) {
        JsonUtil jsonUtil = new JsonUtil();
        List<Blog> blogs = blogService.getBlogByUserId(user.getId());
        if (blogs.isEmpty()) {
            jsonUtil.setState(STATE_EXCEPTION);
            jsonUtil.setMsg("你还没写blog");
        } else {
            jsonUtil.setState(STATE_OK);
            jsonUtil.setMsg("成功");
            jsonUtil.setData(blogs);
        }
        return jsonUtil;
    }

    @RequestMapping("/upBlog")
    public JsonUtil upBlog(@RequestBody Blog blog) {
        JsonUtil jsonUtil = new JsonUtil();

        if (blogService.addBlog(blog) == NOT_ALTER) {
            jsonUtil.setState(STATE_EXCEPTION);
            jsonUtil.setMsg("Blog发布失败");
            jsonUtil.setData(blog);
        } else {
            jsonUtil.setState(STATE_OK);
            jsonUtil.setMsg("Blog发布成功");
            jsonUtil.setData(blog);
        }
        return jsonUtil;
    }

    @RequestMapping("/Alter")
    public JsonUtil blogAlter(@RequestBody Blog blog) {
        JsonUtil jsonUtil = new JsonUtil();

        if (blogService.updateBlog(blog) == NOT_ALTER) {
            jsonUtil.setState(STATE_EXCEPTION);
            jsonUtil.setMsg("blog修改失败");
        } else {
            jsonUtil.setState(STATE_OK);
            jsonUtil.setMsg("blog修改成功");

            //返回最新blog
            Blog nowBlog = blogService.getBlogById(blog.getId());
            jsonUtil.setData(nowBlog);
        }
        return jsonUtil;
    }

    @RequestMapping("/SelectBlog")
    public JsonUtil selectBlog(@RequestBody Blog blog) {
        JsonUtil jsonUtil = new JsonUtil();
        List<Blog> blogs = blogService.getBlogsByTitle(blog.getTitle());
        if (blogs.isEmpty()) {
            jsonUtil.setState(STATE_EXCEPTION);
            jsonUtil.setMsg("没有查询到");
        } else {
            jsonUtil.setState(STATE_OK);
            jsonUtil.setData(blogs);
            jsonUtil.setMsg("查询成功");
        }
        return jsonUtil;
    }

    @RequestMapping("/AllBlog")
    public JsonUtil AllBlog(){
        JsonUtil jsonUtil = new JsonUtil();
        List<Blog> allBlog = blogService.getAllBlog();
        jsonUtil.setData(allBlog);
        if (allBlog.isEmpty()){
            jsonUtil.setState(STATE_EXCEPTION);
            jsonUtil.setMsg("没有blog");
        }else {
            jsonUtil.setState(STATE_OK);
            jsonUtil.setMsg("获取所有blog成功");
        }
        return jsonUtil;
    }

}
