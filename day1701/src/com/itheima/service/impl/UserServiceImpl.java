package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.PageBean;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.BeanFactory;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao= BeanFactory.newInstance(UserDao.class);
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void delById(String id) {
        userDao.delById(id);
    }

    @Override
    public List<User> findByCondition(String sex, String address) {
        return userDao.findByCondition(sex,address);
    }

    @Override
    public List<User> findByPage(int pageNumber, int pageSize) {
        return userDao.findByPage(pageNumber,pageSize);
    }

    @Override
    public int findTotal() {
        return userDao.findTotal();
    }

    @Override
    public PageBean<User> findByPageWithPB(int pageNumber, int pageSize) {
        PageBean<User> pageBean = new PageBean<>();

        //需要五样数据

        pageBean.setPageNumber(pageNumber);
        pageBean.setPageSize(pageSize);

        //数据?
        List<User> data = userDao.findByPage(pageNumber, pageSize);

        pageBean.setData(data);

        //查询总条数
        int total = userDao.findTotal();

        pageBean.setTotal(total);


        return pageBean;
    }

    @Override
    public String findUser(String username) {
        long count = userDao.findUser(username);
        if (count > 0) {
            return "1";
        } else {
            return "0";
        }
    }
}
