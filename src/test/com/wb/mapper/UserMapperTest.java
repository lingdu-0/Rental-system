package com.wb.mapper;

import com.wb.pojo.User;
import com.wb.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapperTest extends BaseTest {
    @Autowired
    private UserMapper userMapper;

    /**
     * 测试添加用户
     */
    @Test
    public void add() {
        User user = new User("卢姥爷", "123", "123", "卢本伟");
        System.out.println(userMapper.add(user));
    }

    @Test
    public void findOne() {
        User user = new User();
        //user.setUserId(1);
        user.setUserName("卢姥爷");
        System.out.println(userMapper.findOne(user));
    }
}
