package com.itheima.dao;

import com.itheima.Utils.C3P0UtilsXML;
import com.itheima.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {

    public User login(String username, String password) {
        QueryRunner qr = new QueryRunner(C3P0UtilsXML.getDataSource());
        try {
            return qr.query("select * from user where username=? and password=?",new BeanHandler<>(User.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
