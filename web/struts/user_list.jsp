<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*" %>
<%@page import="com.dive2sky.user.*" %>
<%@ include file="loginCheck.jsp" %>
<%
    List userList = (List)request.getAttribute("userList");
%>
<html>
<head>
    <title>Chapter1 사용자 관리</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel=stylesheet href="../css/user.css" type="text/css">
    <script language="JavaScript">
        function userCreate() {
            f.action = "user_writeForm.do";
            f.submit();
        }
    </script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<form name="f" method="post" action="user_write.jsp">
    <input type="hidden" name="command" />
    <table width=780 border=0 cellpadding=0 cellspacing=0>
        <tr>
            <td width="20"></td>
            <td>
                <!--contents-->
                <table width=590 border=0 cellpadding=0 cellspacing=0>
                    <tr>
                        <td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>사용자 관리 - 리스트</b></td>
                    </tr>
                </table>
                <br>

                <!-- list -->
                <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
                    <tr>
                        <td width=190 align=center bgcolor="E6ECDE" height="22">사용자 아이디</td>
                        <td width=200 align=center bgcolor="E6ECDE">이름</td>
                        <td width=200 align=center bgcolor="E6ECDE">이메일</td>
                    </tr>
                    <%
                        Iterator userIter = userList.iterator();

                        //사용자 리스트를 클라이언트에게 보여주기 위하여 출력.
                        while ( userIter.hasNext() ) {
                            User user = (User)userIter.next();
                    %>
                    <tr>
                        <td width=190 align=center bgcolor="ffffff" height="20">
                            <%= user.getUserId() %>
                        </td>
                        <td width=200 bgcolor="ffffff" style="padding-left:10">
                            <a href="user_view.jsp?userId=<%= user.getUserId() %>" class="user">
                                <%= user.getName() %>
                            </a>
                        </td>
                        <td width=200 align=center bgcolor="ffffff">
                            <%= user.getEmail() %>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </table>
                <!-- /list -->

                <br>
                <!-- button -->
                <table border="0" cellpadding="0" cellspacing="1" width="590">
                    <tr>
                        <td align="right">
                            <input type="button" value="사용자 추가" onClick="userCreate()"/>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</form>
</body>
</html>