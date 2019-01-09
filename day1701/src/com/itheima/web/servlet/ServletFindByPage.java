package com.itheima.web.servlet;

import com.itheima.domain.PageBean;
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

@WebServlet("/findByPage")
public class ServletFindByPage extends HttpServlet {
    private UserService userService= BeanFactory.newInstance(UserService.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.获取第几页数据
//        如果不传参数 我认为是第一页
        int pageNumber=1;
        String pageNumber_str = request.getParameter("pageNumber");
        if(pageNumber_str!=null){
            pageNumber=Integer.parseInt(pageNumber_str);
        }
        //每页显示个数
        int pageSize=5;

/*//        2.调用service查询数据  条件 (pageNumber,pageSize) 返回list<user>
        List<User> users=userService.findByPage(pageNumber,pageSize);
//        3.放入request
        request.setAttribute("users",users);


        //需要总条数
        //导致需要总页数 和每页显示的个数
        int total=userService.findTotal();
        //向上取整
        int totalPage=(int)Math.ceil(total*1.0/pageSize);
        request.setAttribute("totalPage",totalPage);
        //需要当前是第几页
        request.setAttribute("pageNumber",pageNumber);*/

        //调用一个方法  做完所有事情

        PageBean<User> pb=userService.findByPageWithPB(pageNumber,pageSize);

        request.setAttribute("pb",pb);



//        4.交给jsp展示
        request.getRequestDispatcher("/list03.jsp").forward(request,response);
    }
}
