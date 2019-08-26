package com.wb.converter;

import com.wb.pojo.User;
import com.wb.vo.UserVo;

public class UserConverter {
    public static User convert(UserVo userVo) {
        User user = new User();
        user.setUserName(userVo.getName());
        user.setUserPass(userVo.getPassword());
        user.setUserTel(userVo.getTelephone());
        user.setUserRealName(userVo.getUsername());
        return user;
    }
}
