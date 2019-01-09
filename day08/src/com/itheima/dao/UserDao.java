package com.itheima.dao;

import com.itheima.domain.user;
import com.itheima.utils.C3P0UtilsXML;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    public user login(String username, String password) {
        QueryRunner qr = new QueryRunner(C3P0UtilsXML.getDataSource());
        try {
            return qr.query("SELECT * FROM USER WHERE username=? AND PASSWORD=?;",new BeanHandler<>(user.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
