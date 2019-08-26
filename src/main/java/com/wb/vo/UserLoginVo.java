package com.wb.vo;

import javax.validation.constraints.NotNull;


public class UserLoginVo {
    @NotNull
    private String name;
    @NotNull
    private String password;
    private Integer result;

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

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "UserLoginVo{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", result=" + result +
                '}';
    }
}
