package com.itheima.dao.impl;

import com.itheima.dao.KWDao;
import com.itheima.domain.User;
import com.itheima.domain.Usery;
import com.itheima.utils.DataSourceUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class KWDaoImpl implements KWDao {
    @Override
    public List<Usery> findKW(String content) {
        //创建qr
        QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());

        //编写sql
        String sql="select * from kw where name like ? limit 0,4;";

        //执行sql
        try {
            return qr.query(sql,new BeanListHandler<>(Usery.class),"%"+content+"%");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }



    }
}
