package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserService {
    public User login(String username, String password) {
        return new UserDao().login(username,password);
    }
}
