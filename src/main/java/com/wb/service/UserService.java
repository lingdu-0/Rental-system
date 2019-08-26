package com.wb.service;

import com.wb.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    int reg(User user);
    User login(String userName);
    User findOne(User user);
}
