<%--
  Created by IntelliJ IDEA.
  User: kriw
  Date: 2021/1/16
  Time: 1:23 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生</title>
    <link rel="stylesheet" href="/css/student/studentModel.css">
    <script src="/js/jquery-1.9.1.js"></script>
    <script src="/js/student/studentModel.js"></script>
</head>
<body>
<div id="header">
    <div id="innerNav">
        <a href="javascript:void(0)" id="navPicture" title="返回首页"><img src="/image/IMG_1089.PNG"></a>
        <div id="navLog">
            <span>Welcome,</span>
            <span>xxx</span>
            <button id="btn_cancel">注销</button>
        </div>
        <ul class="navGroup">
            <li class="navGroup_item"><a href="javascript:void(0)" id="nav_toStudentHome">个人主页</a></li>
            <li class="navGroup_item"><a href="javascript:void(0)" id="nav_toPermittedExamList">考试列表</a></li>
            <li class="navGroup_item"><a href="javascript:void(0)" id="nav_toSignedExams">我的考试</a></li>
        </ul>
    </div>
</div>
<div id="container">
    <div id="bgIMG">
        <img src="/image/studentBG.JPG" id="img_background">
    </div>
    <div id="context">

    </div>
</div>
<div id="hiddenArea">
    <form action="/page/toStudentHome.do"id="form_toStudentHome" method="post"></form>
    <form action="/page/toPermittedExamList.do"id="form_toPermittedExamList" method="post"></form>
    <form action="/page/toSignedExams.do"id="form_toSignedExams" method="post"></form>
    <form action="/page/logout.do" id="form_logOut" method="post"></form>
    <input type="hidden" id="userName" value="${sessionScope.userName}">
    <input type="hidden" id="name" value="${sessionScope.name}">
</div>
</body>
</html>
