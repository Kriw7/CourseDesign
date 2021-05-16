<%--
  Created by IntelliJ IDEA.
  User: kriw
  Date: 2020/12/31
  Time: 9:29 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>登陆页面</title>
    <link rel="stylesheet" href="css/login.css">
    <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="js/login.js"></script>
</head>
<body>
    <div id="head" align="center">
        <h1>等级考试报名系统！</h1>
    </div>
    <div id="center" >
        <div id="loginArea" align="center">
            <div>
                <form action="" id="loginForm" method="post">
                    <table>
                        <tr>
                            <td><span class="tipSpan">用户名</span></td>
                            <td><input type="text" name="userName" id="userName" class="logText"></td>
                        </tr>
                        <tr>
                            <td><span class="tipSpan">密&nbsp;&nbsp;&nbsp;&nbsp;码</span></td>
                            <td><input type="password" name="password" id="password" class="logText"></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div id="btnArea">
                <button type="button" class="btn" id="btn_login">登陆</button>
                <button type="button" class="btn" id="btn_register">注册</button>
                <button type="button" class="btn" id="btn_index">返回</button>
            </div>
        </div>
    </div>
</body>
</html>
