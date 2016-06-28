<%@page contentType="text/html; charset=utf-8" %>
<%@page import="com.dive2sky.user.*" %>
<%@ include file="loginCheck.jsp" %>
<%
    String userId = request.getParameter("userId");

    UserManager manager = UserManager.instance();
    manager.remove(userId);

    response.sendRedirect("user_list.jsp");
%>