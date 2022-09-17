package com.peixun.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peixun.test.mapper.BlogMapper;
import com.peixun.test.entity.Blog;
import com.peixun.test.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    private final static int NOT_DELETE = 0;

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public int addBlog(Blog blog) {
        int addCount = blogMapper.insert(blog);
        return addCount;
    }

    @Override
    public int deleteBlog(int id, int userId) {
        HashMap<String, Object> idMap = new HashMap<>();
        idMap.put("user_id", userId);
        idMap.put("id", id);
        int deleteCount = blogMapper.deleteByMap(idMap);
        return deleteCount;

    }

    @Override
    public int updateBlog(Blog blog) {
        //根据用户id更新blog
        UpdateWrapper<Blog> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",blog.getId());
        updateWrapper.set("title", blog.getTitle());
        updateWrapper.set("content", blog.getContent());
        int updateCount = blogMapper.update(blog, updateWrapper);
        return updateCount;
    }

    @Override
    public Blog getBlogById(int id) {
        Blog blog = blogMapper.selectById(id);
        return blog;
    }

    @Override
    public List<Blog> getBlogByUserId(Long userId) {
        //根据用户id查询对应blog
        HashMap<String, Object> idMap = new HashMap<>();
        idMap.put("user_id", userId);
        idMap.put("is_deleted", NOT_DELETE);
        List<Blog> blogs = blogMapper.selectByMap(idMap);
        return blogs;
    }

    @Override
    public List<Blog> getBlogsByTitle(String title) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", title);
        queryWrapper.eq("is_deleted", NOT_DELETE);
        List list = blogMapper.selectList(queryWrapper);
        return list;
    }

    @Override
    public List<Blog> getAllBlog() {
        List<Blog> blogs = blogMapper.selectList(null);
        return blogs;
    }


}
