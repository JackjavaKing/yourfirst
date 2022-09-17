package com.peixun.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.peixun.test.entity.Blog;
import org.springframework.stereotype.Repository;

//blog数据库dao
@Repository
public interface BlogMapper extends BaseMapper<Blog> {

}
