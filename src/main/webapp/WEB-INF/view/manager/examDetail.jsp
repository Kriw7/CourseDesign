<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: kriw
  Date: 2021/1/14
  Time: 9:25 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详细的考试说明</title>
    <link rel="stylesheet" href="/css/manager/examDetail.css">
    <script src="/js/jquery-1.9.1.js"></script>
    <script src="/js/manager/examDetail.js"></script>
</head>
<%
    Object msg = request.getAttribute("message");
    String message = "";
    if (msg!=null) message = (String)msg;
    if (message!=null && !message.equals("")){
        PrintWriter writer = response.getWriter();
        writer.write("<script>alert('"+message+"');</script>");
        request.removeAttribute("message");
    }
%>
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
        <h1>${examName}</h1>
        <h2>（管理者：<span id="examController"></span>）</h2>
        <table id="table_examdDetail">
            <tr>
                <td>考试类型:<span id="examType"></span></td>
                <td>考试等级:<span id="examLevel"></span></td>
            </tr>
            <tr>
                <td>当前报名人数：<span id="examNums"></span></td>
                <td>当前考试状态：<span id="examStatus"></span></td>
            </tr>
            <tr>
                <td>可报名的最大年级：<span id="examMaxGrade"></span></td>
                <td>可报名的专业：<span id="examMajors"></span></td>
            </tr>
            <tr>
                <td>考试开始时间:<span id="examBeginTime"></span></td>
                <td>考试结束时间:<span id="examEndTime"></span></td>
            </tr>
            <tr>
                <td>报名开始时间:<span id="examSignBeginTime"></span></td>
                <td>报名结束时间:<span id="examSignEndTime"></span></td>
            </tr>
            <tr>
                <td colspan="2">
                    <span>考试内容</span>
                    <p id="examContent"></p>
                </td>
            </tr>
        </table>
        <div id="btnArea">
            <button class="btn_function" id="btn_deleteExam">删除考试</button>
            <button class="btn_function" id="btn_backList">返回列表</button>
        </div>
    </div>
</div>
<div id="hiddenArea">
    <form action="/page/toManagerHome.do" id="form_toManagerHome" method="post"></form>
    <form action="/page/toAddExam.do" id="form_addExam" method="post"></form>
    <form action="/page/toAddRoom.do" id="form_addRoom" method="post"></form>
    <form action="/page/toExamList.do" id="form_examList" method="post"></form>
    <form action="/page/logout.do" id="form_logOut" method="post"></form>
    <form action="/page/toArrangeRoom.do" id="form_arrangeRoom" method="post">
        <input type="hidden" id="examName" name="examName" value="${examName}">
    </form>
    <form action="/page/toUpdateExam.do" id="form_updateExam" method="post">
        <input type="hidden" name="examName" value="${examName}">
    </form>
    <input type="hidden" id="userName" value="${sessionScope.userName}">
    <input type="hidden" id="name" value="${sessionScope.name}">
</div>
</body>
</html>
