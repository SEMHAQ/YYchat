package com.yychat.model;

import java.io.*;
/**
 * Author:SEMHAQ
 * Date:2023年 03 月05日
 * Time:14:05
 * File:User.java
 * Software:IntelliJ IDEA
 */
public class User implements Serializable{
    String username;
    String password;

    String userType;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
