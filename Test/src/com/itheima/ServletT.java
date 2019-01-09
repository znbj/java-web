package com.itheima;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/ServletT")
public class ServletT extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        QueryRunner qr = new QueryRunner(C3P0UtilsXML.getDataSource());
        try {
            user query = qr.query("SELECT * FROM USER WHERE username=? AND PASSWORD=?;", new BeanHandler<>(user.class), username, password);
            if (query == null) {
                response.getWriter().print("登陆失败");
            } else {
                response.getWriter().print("登陆成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
