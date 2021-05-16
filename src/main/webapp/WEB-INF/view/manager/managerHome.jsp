<%--
  Created by IntelliJ IDEA.
  User: kriw
  Date: 2021/1/14
  Time: 1:10 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员主页</title>
    <link rel="stylesheet" href="/css/manager/managerHome.css">
    <script src="/js/jquery-1.9.1.js"></script>
    <script src="/js/manager/managerHome.js"></script>
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
                <li class="navGroup_item"><a href="javascript:void(0)" id="nav_toHome">首页</a></li>
                <li class="navGroup_item"><a href="javascript:void(0)" id="nav_toExamList">考试列表</a></li>
                <li class="navGroup_item"><a href="javascript:void(0)" id="nav_toAddExam">添加考试</a></li>
                <li class="navGroup_item"><a href="javascript:void(0)" id="nav_toAddRoom">增加教室</a></li>
            </ul>
        </div>
    </div>
    <div id="container">
        <div id="bgIMG">
            <img src="/image/68686407_p0.jpg" id="img_background">
        </div>
        <div id="context">
            <h1>管理员使用说明与注意事项</h1>
            <div id="introduce">
                <p>1.在考试列表，可以查看当前的考试列表，点击考试名称就可以查看考试的详情。</p>
                <p>2.在添加考试部分，可以添加一场新的考试。</p>
                <p>3.增加教室一览，可以增加教室的信息。</p>
                <p>4.在一场考试的报名时间结束后，请及时对报名结束的教室分配考场。</p>
                <p>5.请注意个人隐私的防护。</p>
            </div>
        </div>
    </div>
    <div id="hiddenArea">
        <form action="/page/toManagerHome.do" id="form_toManagerHome" method="post"></form>
        <form action="/page/toAddExam.do" id="form_addExam" method="post"></form>
        <form action="/page/toAddRoom.do" id="form_addRoom" method="post"></form>
        <form action="/page/toExamList.do" id="form_examList" method="post"></form>
        <form action="/page/logout.do" id="form_logOut" method="post"></form>
        <input type="hidden" id="userName" value="${sessionScope.userName}">
        <input type="hidden" id="name" value="${sessionScope.name}">
    </div>
</body>
</html>
