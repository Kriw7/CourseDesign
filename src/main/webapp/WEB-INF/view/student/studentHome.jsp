<%--
  Created by IntelliJ IDEA.
  User: kriw
  Date: 2021/1/14
  Time: 12:55 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生</title>
    <link rel="stylesheet" href="/css/student/studentHome.css">
    <script src="/js/jquery-1.9.1.js"></script>
    <script src="/js/student/studentHome.js"></script>
</head>
<body>
<div id="header">
    <div id="innerNav">
        <a href="javascript:void(0)" id="navPicture" title="返回首页"><img src="/image/IMG_1089.PNG"></a>
        <div id="navLog">
            <span>Welcome,</span>
            <span>${sessionScope.name}</span>
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
        <h1>个人信息和注意事项</h1>
        <div id="profileArea">
            <img src="/image/profile.jpg" width="200px" id="img_profile" >
        </div>
        <table id="table_student">
            <tr>
                <td>姓名：<span id="span_studentName"></span></td>
                <td>年龄：<span id="span_studentAge"></span></td>
                <td>性别：<span id="span_studentGender"></span></td>
            </tr>
            <tr>
                <td>年级：<span id="span_studentGrade"></span></td>
                <td>专业：<span id="span_studentMajor"></span></td>
                <td>班级：<span id="span_studentClassOrder"></span></td>
            </tr>
        </table>
        <div id="introduce">
            <h2>诚信考试公约</h2>
            <p>1.自觉遵守考场规定，不携带规定以外的物品，按要求就绪入座。</p>
            <p>2.在考试中不交头接耳、互打暗号或手势。</p>
            <p>3.未经监考人员同意不擅自离开考场。</p>
            <p>4.不在考试开始信号发出前或考试结束信号后继续答题。</p>
        </div>
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

