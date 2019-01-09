<%@ page import="java.util.Map" %>
<%@ page import="com.itheima.domain.user" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: znbs
  Date: 2018/9/4
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<table width="60%" border="1px" cellspacing="1px" align="center">
<tr>

    <td>用户名</td>
    <td>密码</td>
    <td>邮箱</td>
    <td>姓名</td>
    <td>性别</td>
    <td>出生日期</td>
</tr>
<%
    List<user> users = (List<user>) request.getAttribute("users");
    for (user user : users) {
        out.print("<tr>");
        out.print("<td>"+user.getUsername()+"</td>");
        out.print("<td>"+user.getPassword()+"</td>");
        out.print("<td>"+user.getEmail()+"</td>");
        out.print("<td>"+user.getName()+"</td>");
        out.print("<td>"+user.getSex()+"</td>");
        out.print("<td>"+user.getBirthday()+"</td>");
        out.print("</tr>");

    }


%>
</table>
</body>
</html>
