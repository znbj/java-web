package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    void delById(String id);

    List<User> findByCondition(String sex, String address);

    List<User> findByPage(int pageNumber, int pageSize);

    int findTotal();

    long findUser(String username);
}
