package com.wb.mapper;

import com.wb.pojo.User;

public interface UserMapper {
    int add(User user);

    User findOne(User user);
}
