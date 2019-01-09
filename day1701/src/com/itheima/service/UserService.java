package com.itheima.service;

import com.itheima.domain.PageBean;
import com.itheima.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void delById(String id);

    List<User> findByCondition(String sex, String address);

    List<User> findByPage(int pageNumber, int pageSize);

    int findTotal();

    PageBean<User> findByPageWithPB(int pageNumber, int pageSize);

    String findUser(String username);
}
