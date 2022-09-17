package com.peixun.test.service;


import com.peixun.test.entity.Blog;

import java.util.List;

public interface BlogService {

    /**
     * 添加blog
     *
     * @param blog blog对象用户id和title不能为null
     * @return 影响数据行数
     */
    int addBlog(Blog blog);

    /**
     * 删除blog
     * 根据blog对象的id和userid删除blog
     *
     * @param id,userId 文章id和用户id
     * @return 影响数据行数
     */
    int deleteBlog(int id, int userId);

    /**
     * 更新blog
     * 根据blog对象的id和userid更新blog
     *
     * @param blog blog对象的userid和id不能为null
     * @return 影响行数
     */
    int updateBlog(Blog blog);

    /**
     * 传入用户id搜索blog
     *
     * @param id 用户id
     * @return 用户对应blog
     */
     Blog getBlogById(int id);


    /**
     * 传入用户id搜索blog
     *
     * @param userId 用户id
     * @return 用户对应blog
     */
    List<Blog> getBlogByUserId(Long userId);


    /**
     * 传入title搜索blog
     *
     * @param title blog的title
     * @return 该title的blog集合
     */
    List<Blog> getBlogsByTitle(String title);

    /**
     * 所有blog
     *
     * @return 所有blog集合
     */
    List<Blog> getAllBlog();
}
