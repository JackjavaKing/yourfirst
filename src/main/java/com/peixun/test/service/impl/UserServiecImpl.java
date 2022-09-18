package com.peixun.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peixun.test.entity.JsonUtil;
import com.peixun.test.entity.User;
import com.peixun.test.mapper.UserMapper;
import com.peixun.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiecImpl extends ServiceImpl<UserMapper, User> implements UserService  {// UserDetailsService

    private static final int STATE_OK=1;
    private static final int STATE_EXCEPTION=0;



    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册实现类
     *
     * @param user
     * @return insert 如果返回1，表示注册成功
     */
    @Override
    public JsonUtil registUser(User user) {
        HashMap<String, Object> accountMap = new HashMap<>();
        accountMap.put("account_num",user.getAccountNum());
        JsonUtil jsonUtil = new JsonUtil();
        List<User> users = userMapper.selectByMap(accountMap);
        if (!users.isEmpty()) {
            System.out.println("account_num存在");
            jsonUtil.setState(STATE_EXCEPTION);
            jsonUtil.setMsg("用户已存在");
        }else {
            int result = userMapper.insert(user);
            jsonUtil.setState(STATE_OK);
            jsonUtil.setMsg("注册成功");
        }
        return jsonUtil;
    }

    /**
     * 用户登录实现类
     *
     * @param user
     * @return 如果返回1，表示注册成功
     */
    @Override
    public JsonUtil login(User user) {

        HashMap<String, Object> accountMap = new HashMap<>();
        accountMap.put("account_num", user.getAccountNum());
        accountMap.put("account_password", user.getAccountPassword());
        List<User> users = userMapper.selectByMap(accountMap);
        JsonUtil jsonUtil = new JsonUtil();
        if (users.isEmpty()){
            jsonUtil.setState(STATE_EXCEPTION);
            jsonUtil.setMsg("用户名或密码错误");
        }else {
            jsonUtil.setState(STATE_OK);
            jsonUtil.setMsg("登录成功");
            jsonUtil.setData(users);
        }
        return jsonUtil;
    }

//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User u = new User();
//        u.setUsername(username);
//        Example<User> example = Example.of(u);
//        Optional<User> optional  = userDao.findOne(example);
//        u = optional.orElseGet(new Supplier<User>() {
//            @Override
//            public User get() {
//                return null;
//            }
//        });
//        if(u==null){
//            return null;
//        }
//        org.springframework.security.core.userdetails.User user2 = new org.springframework.security.core.userdetails.User(u.getUname(),u.getUpwd());
//        return user2;
//    }
}
