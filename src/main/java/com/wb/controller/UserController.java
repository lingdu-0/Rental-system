package com.wb.controller;

import com.wb.converter.UserConverter;
import com.wb.pojo.User;
import com.wb.service.UserService;
import com.wb.vo.UserLoginVo;
import com.wb.vo.UserRegVo;
import com.wb.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("reg")
    public String reg() {
        return "regs";
    }

    @RequestMapping("doReg")
    public String doReg(@ModelAttribute("userVo") @Valid UserVo userVo, BindingResult result) {
        System.out.println(userVo);
        if (result.hasErrors()) {
            return "regs";
        }
        User user = UserConverter.convert(userVo);
        userService.reg(user);
        return "redirect:login";
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("doLogin")
    @ResponseBody
    public UserLoginVo doLogin(@Valid UserLoginVo userLoginVo, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            userLoginVo.setResult(1);
        }
        User user = userService.login(userLoginVo.getName());
        System.out.println(user);
        if (user != null && userLoginVo.getPassword().equals(user.getUserPass())) {
            session.setAttribute("user", user);
            userLoginVo.setResult(2);
        } else {
            userLoginVo.setResult(3);
        }
        return userLoginVo;
    }

    @RequestMapping("doReg2")
    @ResponseBody
    public UserRegVo doReg2(String name) {
        User user = new User();
        user.setUserName(name);
        UserRegVo userRegVo = new UserRegVo();
        if (userService.findOne(user) == null)
            userRegVo.setResult(true);
        else
            userRegVo.setResult(false);
        return userRegVo;
    }
}
