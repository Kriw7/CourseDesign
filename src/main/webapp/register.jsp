<%--
  Created by IntelliJ IDEA.
  User: kriw
  Date: 2021/1/1
  Time: 4:32 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Register</title>
    <link rel="stylesheet" href="css/register.css">
    <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="js/register.js"></script>
</head>
<body>
<div id="background"></div>
<div id="window-container">
    <div id="container-background"></div>
    <div id="container-title">
        <h1>等级考试报名系统</h1>
    </div>
    <form action="/student/register.do" method="post" id="registerForm">
        <div class="register_column">
            <span>用户名</span>
            <input type="text" name="userName" id="userName" placeholder="取一个响亮的名字吧❀" >
            <div class="tips">
                <span id="span_userName"></span>
            </div>
        </div>
        <div class="register_column" >
            <span>密码</span>
            <input type="password" name="password" id="password" placeholder="密码没有什么限制~" >
            <div class="tips"><span id="span_passwd"></span></div>
        </div>
        <div class="register_column" >
            <span>密码确认</span>
            <input type="password" id="password2" placeholder="注意要与上一次相同喔" >
            <div class="tips"><span id="span_passwd2"></span></div>
        </div>
        <div class="register_column" >
            <span>姓名</span>
            <input type="text"  name="name" id="name" placeholder="我们拒收张三" >
            <div class="tips"><span id="span_name"></span></div>
        </div>
        <div class="register_column"  >
            <span>性别</span>
            <label class="label_radio"><input type="radio" name="gender" value="男" checked>男</label>
            <label class="label_radio"><input type="radio" name="gender" value="女">女</label>
            <div class="tips"><span id="span_gender"></span></div>
        </div>
        <div class="register_column"  >
            <span>年龄</span>
            <select name="age" class="mySelect" id="select_age"></select>
            <span>年级</span>
            <select name="grade" class="mySelect">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </select>
            <span>班级</span>
            <select name="classOrder" class="mySelect">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
            </select>
            <div class="tips"><span id="span_other"></span></div>
        </div>
        <div class="register_column"  >
            <span>专业</span>
            <input type="text" name="major" id="major" placeholder="~" required>
            <div class="tips"><span id="span_major"></span></div>
        </div>
        <div id="btn_area">
            <input type="button" value="提交" id="btn_register">
            <input type="button" value="取消" id="btn_cancel"><br>
            <p id="ornament">🌸</p>
        </div>
    </form>
</div>
    <div id="hiddenArea">
        <input type="hidden" id="jUserNameResult" value="1">
    </div>
</body>
</html>
