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
    <form action="" method="post" id="registerForm">
        <div class="register_column">
            <span>用户名</span>
            <input type="text" name="userName" id="userName" placeholder="取一个响亮的名字吧❀" required>
            <div class="tips">
                <span id="span_userName"></span>
            </div>
        </div>
        <div class="register_column" >
            <span>密码</span>
            <input type="password" name="password" id="password" placeholder="密码没有什么限制~" required>
            <div class="tips"><span id="span_passwd"></span></div>
        </div>
        <div class="register_column" >
            <span>密码确认</span>
            <input type="password" id="password2" placeholder="注意要与上一次相同喔" required>
            <div class="tips"><span id="span_passwd2"></span></div>
        </div>
        <div class="register_column" >
            <span>真实姓名</span>
            <input type="text"  name="name" id="name" placeholder="我们拒收张三" required>
            <div class="tips"><span id="span_name"></span></div>
        </div>
        <div class="register_column" >
            <span>个人介绍</span>
            <input type="text"  name="intro" id="intro" placeholder="whatever you like！"required>
            <div class="tips"><span id="span_intro"></span></div>
        </div>
        <div class="register_column"  >
            <span>性别</span>
            <input type="text" name="gender" id="gender" placeholder="本店没有任何歧视~" required>
            <div class="tips"><span id="span_gender"></span></div>
        </div>
        <div class="register_column"  >
            <span>省份</span>
            <input type="text" name="province" id="province" placeholder="按各国行政划分来" required>
            <div class="tips"><span id="span_province"></span></div>
        </div>
        <div class="register_column"  >
            <span>城市</span>
            <input type="text" name="city" id="city" placeholder="NightCity?" required>
            <div class="tips"><span id="span_city"></span></div>
        </div>
        <div class="register_column">
            <span>联系电话</span>
            <input type="text"  name="mobile" id="mobile" placeholder="歪？在吗" required>
            <div class="tips"><span id="span_mobile"></span></div>
        </div>
        <div class="register_column"  >
            <span>电子邮箱</span>
            <input type="text" name="email" id="email" placeholder="找回账号的唯一途径" required>
            <div class="tips"><span id="span_email"></span></div>
        </div>
        <div class="register_column"  >
            <span>QQ</span>
            <input type="text" name="QQ" id="QQ" placeholder="常用的QQ～" required>
            <div class="tips"><span id="span_QQ"></span></div>
        </div>
        <div id="btn_area">
            <input type="submit" value="提交" id="btn_register">
            <input type="button" value="取消" id="btn_cancel"><br>
            <p id="ornament">🌸</p>
        </div>
    </form>
</div>
</body>
</html>
