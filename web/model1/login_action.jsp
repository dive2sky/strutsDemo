<%@page contentType="text/html; charset=utf-8" %>
<%@page import="com.dive2sky.user.*" %>
<%
    try {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        //모델에 로그인 작업을 위임한다.
        UserManager manager = UserManager.instance();
        manager.login(userId, password);

        //정상적으로 로그인 되었을 경우 세션에 사용자 아이디 저장.
        session = request.getSession();
        session.setAttribute("userId", userId);

        //모든 작업 완료후 이동할 페이지를 결정.
        response.sendRedirect("user_list.jsp");
    } catch (Exception e) {
%>
<!--
에러가 발생할 경우 이전 페이지로 이동.
-->
<script language="javascript">
    alert("<%= e.getMessage() %>");
    history.back();
</script>
<%
    }
%>