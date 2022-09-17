package com.peixun.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.peixun.test.entity.User;
import org.springframework.stereotype.Repository;


//用户数据库dao
@Repository
public interface UserMapper extends BaseMapper<User> {

}
