package com.wb.service.impl;

import com.wb.mapper.UserMapper;
import com.wb.pojo.User;
import com.wb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int reg(User user) {
         return userMapper.add(user);
    }

    @Override
    public User login(String userName) {
        User user = new User();
        user.setUserName(userName);
        return userMapper.findOne(user);
    }

    @Override
    public User findOne(User user) {
        return userMapper.findOne(user);
    }
}
