package com.peixun.test.controller;
import com.peixun.test.entity.Blog;
import com.peixun.test.entity.JsonUtil;
import com.peixun.test.entity.User;
import com.peixun.test.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import static com.peixun.test.entity.JsonUtil.STATE_OK;

@Component
@RestController
@RequestMapping("/BlogIndex")
public class BlogController {

    private final int NOT_ALTER = 0;        // 校验数据库有无发生行变化改变

    @Autowired
    private BlogService blogService;

    //用户个人blog
    @RequestMapping("/myBlog")
    public JsonUtil myBlog(@RequestBody User user) {
        JsonUtil jsonUtil = new JsonUtil();
        List<Blog> blogs = blogService.getBlogByUserId(user.getId());
        if (blogs.isEmpty()) {
            jsonUtil.setMsg("你还没写blog");
        } else {
            jsonUtil.setState(STATE_OK);
            jsonUtil.setMsg("成功");
            jsonUtil.setData(blogs);
        }
        return jsonUtil;
    }

    //blog发布功能
    @RequestMapping("/upBlog")
    public JsonUtil upBlog(@RequestBody @Valid Blog blog, Errors errors) {
        JsonUtil jsonUtil = new JsonUtil();
        //数据校验
        if (errors.hasErrors()) {
            jsonUtil.setMsg(errors.getFieldError().getDefaultMessage());
            return jsonUtil;
        }

        //blog持久化
        if (blogService.addBlog(blog) == NOT_ALTER) {
            jsonUtil.setMsg("Blog发布失败");
            jsonUtil.setData(blog);
        } else {
            jsonUtil.setState(STATE_OK);
            jsonUtil.setMsg("Blog发布成功");
            jsonUtil.setData(blog);
        }
        return jsonUtil;
    }

    //修改blog功能
    @RequestMapping("/Alter")
    public JsonUtil blogAlter(@RequestBody Blog blog) {
        JsonUtil jsonUtil = new JsonUtil();

        //通过返回修改行数，判断blog是否更改
        if (blogService.updateBlog(blog) == NOT_ALTER) {
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

    //根据关键字查找blog
    @RequestMapping("/SelectBlog")
    public JsonUtil selectBlog(@RequestBody Blog blog) {
        JsonUtil jsonUtil = new JsonUtil();
        List<Blog> blogs = blogService.getBlogsByTitle(blog.getTitle());
        if (blogs.isEmpty()) {
            jsonUtil.setMsg("没有查询到");
        } else {
            jsonUtil.setState(STATE_OK);
            jsonUtil.setData(blogs);
            jsonUtil.setMsg("查询成功");
        }
        return jsonUtil;
    }

    //所有blog
    @RequestMapping("/AllBlog")
    public JsonUtil AllBlog() {
        JsonUtil jsonUtil = new JsonUtil();
        List<Blog> allBlog = blogService.getAllBlog();
        jsonUtil.setData(allBlog);
        if (allBlog.isEmpty()) {
            jsonUtil.setMsg("没有blog");
        } else {
            jsonUtil.setState(STATE_OK);
            jsonUtil.setMsg("获取所有blog成功");
        }
        return jsonUtil;
    }

}
