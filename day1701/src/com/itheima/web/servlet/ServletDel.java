package com.itheima.web.servlet;

import com.itheima.service.UserService;
import com.itheima.utils.BeanFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delUser")
public class ServletDel extends HttpServlet {
    private UserService userService= BeanFactory.newInstance(UserService.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.获取参数 id
        String id = request.getParameter("id");

//        2.调用service 根据id 删除某一条数据
        userService.delById(id);
//        3.删除操作完成 重定向到查询所有 页面
        response.sendRedirect(request.getContextPath()+"/findAll");

    }
}
