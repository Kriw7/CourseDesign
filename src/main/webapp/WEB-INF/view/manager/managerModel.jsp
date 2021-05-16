<%--
  Created by IntelliJ IDEA.
  User: kriw
  Date: 2021/1/15
  Time: 9:59 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员模版</title>
    <link rel="stylesheet" href="/css/manager/managerModel.css">
    <script src="/js/jquery-1.9.1.js"></script>
    <script src="/js/manager/managerModel.js"></script>
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

    </div>
</div>
<div id="hiddenArea">
    <form action="/page/toManagerHome.do" id="form_toManagerHome" method="post"></form>
    <form action="/page/toAddExam.do" id="form_addExam" method="post"></form>
    <form action="/page/toAddRoom.do" id="form_addRoom" method="post"></form>
    <form action="/page/toExamList.do" id="form_examList" method="post"></form>
    <form action="/page/logout.do" id="form_logOut" method="post"></form>
    <form action="/page/toExamDetail.do" id="form_examDetail" method="post">
        <input type="hidden" id="examName" name="examName" value="">
    </form>
    <input type="hidden" id="totalPage" value="">
    <input type="hidden" id="userName" value="${sessionScope.userName}">
    <input type="hidden" id="name" value="${sessionScope.name}">
</div>
</body>
</html>
