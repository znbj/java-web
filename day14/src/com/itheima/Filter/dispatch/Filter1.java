package com.itheima.Filter.dispatch;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "Filter1",urlPatterns = "/*")
public class Filter1 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //首先         
        HttpServletRequest request = (HttpServletRequest)req;
         resp.setContentType("text/html;charset=utf‐8");
        // 获取请求的方式         
        String method = request.getMethod();
        if("post".equalsIgnoreCase(method)){
        // 如果是post请求            
       request.setCharacterEncoding("utf‐8");
            chain.doFilter(req, resp);
        // 结束当前方法             
        return;
       }



    }

    public void init(FilterConfig config) throws ServletException {

    }

}
