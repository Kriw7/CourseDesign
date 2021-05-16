<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: kriw
  Date: 2021/1/14
  Time: 5:30 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加考试</title>
    <link rel="stylesheet" href="/css/manager/addExam.css"/>
    <link rel="stylesheet" href="/timeSource/jquery-ui.min.css"/>
    <link rel="stylesheet" href="/timeSource/jquery-ui-timepicker-addon.css"/>
    <script src="/js/jquery-1.9.1.js"></script>
    <script src="/timeSource/jquery-ui.min.js"></script>
    <script src="/timeSource/jquery-ui-timepicker-addon.js"></script>
    <script src="/timeSource/jquery-ui-timepicker-zh-CN.js"></script>
    <script src="/js/manager/addExam.js"></script>
</head>
<%
    //读取传递过来的添加考试的结果信息
    Object msg = request.getAttribute("addExamResult");
    String message = "";
    if (msg!=null) message = (String)msg;
    if (message!=null && !message.equals("")){
        PrintWriter writer = response.getWriter();
        writer.write("<script>alert('"+message+"');</script>");
        request.removeAttribute("addExamResult");
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
            <h1>添加考试</h1>
            <form action="/exam/addNewExam.do" method="post" id="form_addNewExam">
                <div id="exam_basicInfo">
                    <span>考试类型：</span><input type="text" name="type" id="examType">
                    <span>考试等级：</span><input type="text" name="level"  placeholder="请输入数字~" id="examLevel">
                    <span>考试名称：</span><input type="text" name="name" id="examName">
                </div>
                <div id="exam_duration">
                    <span>考试开始时间：</span><input type="text" name="beginTime" class="input_timepicker" id="examBeginTime" >
                    <span>考试结束时间：</span><input type="text" name="endTime" class="input_timepicker" id="examEndTime">
                </div>
                <div id="exam_signDuration">
                    <span>报名开始时间：</span><input type="text" name="signBeginTime" class="input_timepicker" id="examSignBeginTime">
                    <span>报名结束时间：</span><input type="text" name="signEndTime" class="input_timepicker" id="examSignEndTime">
                </div>
                <div id="exam_limit">
                    <span>允许最大年级与允许的专业：</span>
                    <select name="maxGrade" id="maxGrade">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </select>
                    <div id="majorList">
                        <label>All<input name="permittedMajors" type="checkbox" checked id="checkbox_all" value="all"></label>
                    </div>
                </div>
                <div id="exam_content">
                    <span>考试内容：</span>
                    <textarea  name="content" id="examContent" placeholder="最大字数为255～请不要超过限制."></textarea>
                </div>
                <div id="btn_area">
                    <button type="button" id="btn_addExam" class="btn_function" >提交</button>
                </div>

                <input type="hidden" id="userName" name="userName" value="${sessionScope.userName}">
            </form>
        </div>
    </div>
    <div id="hiddenArea">
        <form action="/page/toManagerHome.do" id="form_toManagerHome" method="post"></form>
        <form action="/page/toAddExam.do" id="form_addExam" method="post"></form>
        <form action="/page/toAddRoom.do" id="form_addRoom" method="post"></form>
        <form action="/page/toExamList.do" id="form_examList" method="post"></form>
        <form action="/page/logout.do" id="form_logOut" method="post"></form>
        <input type="hidden" id="name" value="${sessionScope.name}">
    </div>
</body>
</html>
