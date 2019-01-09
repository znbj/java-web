package com.itheima.dao;

import com.itheima.domain.user;
import com.itheima.utils.C3P0UtilsXML;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

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

    public void register(user use) {
        QueryRunner qr = new QueryRunner(C3P0UtilsXML.getDataSource());
        try {
            qr.update("INSERT INTO USER VALUES (null,?,?,?,?,?,?);", use.getUsername(), use.getPassword(), use.getEmail(), use.getName(), use.getSex(), use.getBirthday());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public List<user> findAll() {
        QueryRunner qr = new QueryRunner(C3P0UtilsXML.getDataSource());
        try {
            return qr.query("SELECT * FROM USER ;",new BeanListHandler<>(user.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
