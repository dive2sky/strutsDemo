<%@page contentType="text/html; charset=utf-8" %>
<%@page import="com.dive2sky.user.*" %>
<%@ include file="loginCheck.jsp" %>
<%
    String userId = request.getParameter("userId");
    String password = request.getParameter("password");
    String name = request.getParameter("name");
    String email = request.getParameter("email");

    User user = new User();
    user.setUserId(userId);
    user.setPassword(password);
    user.setName(name);
    user.setEmail(email);

    UserManager manager = UserManager.instance();
    manager.update(user);

    response.sendRedirect("user_list.jsp");
%>