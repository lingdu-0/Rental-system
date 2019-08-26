package com.wb.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserVo {
    @Pattern(regexp = "^\\w{6,16}$", message = "用户名输入不合法!")
    private String name;
    @Pattern(regexp = "^\\w{6,16}$", message = "密码不合法!")
    private String password;
    @Pattern(regexp = "^\\w{6,16}$", message = "确认密码不合法!")
    private String rgpassword;
    @Pattern(regexp = "^1[0-9]{10}", message = "电话格式不对!")
    private String telephone;
    @NotNull(message = "真实姓名不能为空")
    private String username;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRgpassword() {
        return rgpassword;
    }

    public void setRgpassword(String rgpassword) {
        this.rgpassword = rgpassword;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", rgpassword='" + rgpassword + '\'' +
                ", telephone='" + telephone + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
