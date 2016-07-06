<%@page contentType="text/html; charset=utf-8" %>
<%@page import="com.dive2sky.user.*" %>
<%@ include file="loginCheck.jsp" %>
<%
    User user = (User)request.getAttribute("user");
%>
<html>
<head>
    <title>Chapter1 사용자 관리</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel=stylesheet href="../css/user.css" type="text/css">
    <script language="JavaScript">
        function userList() {
            f.command.value = "list";
            f.action = "user_list.m2";
            f.submit();
        }

        function userModify() {
            f.command.value = "updateForm";
            f.action = "user_modify.m2";
            f.submit();
        }

        function userRemove() {
            if ( confirm("정말 삭제하시겠습니까?") ) {
                f.command.value = "delete";
                f.action = "user_remove.m2";
                f.submit();
            }
        }
    </script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<table width=780 border=0 cellpadding=0 cellspacing=0>
    <tr>
        <td width="20"></td>
        <td>
            <!--contents-->
            <table width=590 border=0 cellpadding=0 cellspacing=0>
                <tr>
                    <td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>사용자 관리 - 사용자 정보보기</b></td>
                </tr>
            </table>
            <br>

            <!-- write Form  -->
            <form name="f" method="post">
                <input type="hidden" name="command"/>
                <input type="hidden" name="userId" value="<%= user.getUserId() %>"/>
                <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
                    <tr>
                        <td width=100 align=center bgcolor="E6ECDE" height="22">사용자 아이디</td>
                        <td width=490 bgcolor="ffffff" style="padding-left:10">
                            <%= user.getUserId() %>
                        </td>
                    </tr>
                    <tr>
                        <td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
                        <td width=490 bgcolor="ffffff" style="padding-left:10">
                            <%= user.getName() %>
                        </td>
                    </tr>
                    <tr>
                        <td width=100 align=center bgcolor="E6ECDE" height="22">이메일 주소</td>
                        <td width=490 bgcolor="ffffff" style="padding-left:10">
                            <%= user.getEmail() %>
                        </td>
                    </tr>
                </table>
            </form>
            <br>

            <table width=590 border=0 cellpadding=0 cellspacing=0>
                <tr>
                    <td align=center>
                        <input type="button" value="수정" onClick="userModify()"> &nbsp;
                        <input type="button" value="삭제" onClick="userRemove()"> &nbsp;
                        <input type="button" value="목록" onClick="userList()">
                    </td>
                </tr>
            </table>

        </td>
    </tr>
</table>

</body>
</html>