<%--
  Created by IntelliJ IDEA.
  User: kriw
  Date: 2021/1/14
  Time: 5:17 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>考试列表</title>
    <link rel="stylesheet" href="/css/manager/examList.css">
    <script src="/js/jquery-1.9.1.js"></script>
    <script src="/js/manager/examList.js"></script>
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
            <table id="table_totalExam">
                <tr>
                    <th>类型</th>
                    <th>等级</th>
                    <th>考试名称</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>报名开始时间</th>
                    <th>报名结束时间</th>
                    <th>当前人数</th>
                    <th>状态</th>
                </tr>
            </table>
            <div id="pageHelper">
                <button type="button" class="btn_page" id="btn_prevPage">上一页</button>
                <button type="button" class="btn_page" id="btn_nextPage">下一页</button>
            </div>
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
