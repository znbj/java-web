package com.itheima.web.servlet;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.BeanFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findByCondition")
public class ServletFindByCondition extends HttpServlet {
    private UserService userService= BeanFactory.newInstance(UserService.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数列表
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");

        //调动service查询
        List<User> users=userService.findByCondition(sex,address);
        //将数据放入request
        request.setAttribute("users",users);

        //把查询条件 放入request域中
        request.setAttribute("sex",sex);
        request.setAttribute("address",address);

        request.getRequestDispatcher("/list01.jsp").forward(request,response);
    }
}
