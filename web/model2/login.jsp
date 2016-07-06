<%@page contentType="text/html; charset=utf-8" %>
<html>
<head>
    <title>Chapter1 사용자 관리</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel=stylesheet href="../css/user.css" type="text/css">
    <script language="JavaScript">
        function userCreate() {
            f.action = "user_write.jsp";
            f.submit();
        }

        function login() {
            if ( f.userId.value == "" ) {
                alert("사용자 아이디를 입력하십시요.");
                f.userId.focus();
                return false;
            }
            if ( f.password.value == "" ) {
                alert("비밀번호를 입력하십시요.");
                f.password.focus();
                return false;
            }

            f.command.value = "login";
            f.action = "login.m2";
            f.submit();
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
                    <td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>사용자 관리 - 로그인</b></td>
                </tr>
            </table>
            <br>

            <!-- write Form  -->
            <form name="f" method="post">
                <input type="hidden" name="command"/>
                <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
                    <tr>
                        <td width=100 align=center bgcolor="E6ECDE" height="22">사용자 아이디</td>
                        <td width=490 bgcolor="ffffff" style="padding-left:10">
                            <input type="text" style="width:150" name="userId">
                        </td>
                    </tr>
                    <tr>
                        <td width=100 align=center bgcolor="E6ECDE" height="22">비밀번호</td>
                        <td width=490 bgcolor="ffffff" style="padding-left:10">
                            <input type="password" style="width:150" name="password">
                        </td>
                    </tr>
                </table>
            </form>
            <br>

            <table width=590 border=0 cellpadding=0 cellspacing=0>
                <tr>
                    <td align=center>
                        <input type="button" value="로그인" onClick="login()"> &nbsp;
                        <input type="button" value="회원가입" onClick="userCreate()">
                    </td>
                </tr>
            </table>

        </td>
    </tr>
</table>

</body>
</html>