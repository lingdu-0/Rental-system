package com.wb.pojo;

public class User {
    private Integer userId;
    private String userName;
    private String userPass;
    private String userTel;
    private String userRealName;

    public User() {
    }

    public User(String userName, String userPass, String userTel, String userRealName) {
        this.userName = userName;
        this.userPass = userPass;
        this.userTel = userTel;
        this.userRealName = userRealName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userRealName='" + userRealName + '\'' +
                '}';
    }
}
