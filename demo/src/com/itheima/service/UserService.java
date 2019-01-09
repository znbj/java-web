package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.domain.user;

public class UserService {
    public user login(String username, String password) {
        return new UserDao().login(username,password);
    }

    public void register(user use) {
        new UserDao().register(use);
    }
}
