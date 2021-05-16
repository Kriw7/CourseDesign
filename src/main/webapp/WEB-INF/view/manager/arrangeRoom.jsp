<%--
  Created by IntelliJ IDEA.
  User: kriw
  Date: 2021/1/17
  Time: 1:27 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>安排考场</title>
    <link rel="stylesheet" href="/css/manager/arrangeRoom.css">
    <script src="/js/jquery-1.9.1.js"></script>
    <script src="/js/manager/arrangeRoom.js"></script>
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
        <h1>安排考场</h1>
        <div id="examInfoArea">
            <p class="p_introduce">考试信息</p>
            <table id="table_examInfo">
                <tr>
                    <td>考试名称：<a href="javascript:void(0)" class="a_examName" title='查看详情'>${examName}</a></td>
                    <td>考试人数：<span id="exam_nums"></span></td>
                </tr>
                <tr>
                    <td>考试开始时间：<span id="exam_beginTime"></span></td>
                    <td>考试结束时间：<span id="exam_endTime"></span></td>
                </tr>
            </table>
        </div>
        <div id="roomListArea">
            <p class="p_introduce">教室列表</p>
            <form action="/room/arrangeRoomForExam.do" method="post" id="form_arrangeRoom">
                <table id="table_arrangeRoom">
                    <tr>
                        <th>教室编号</th>
                        <th>教室大小</th>
                        <th>教室位置</th>
                        <th>教室状态</th>
                        <th>操作状态</th>
                    </tr>
                </table>
                <input type="hidden" name="examName" value="${examName}">
            </form>
            <div id="pageHelper">
                <button id="btn_prevPage" class="btn_page">上一页</button>
                <button id="btn_nextPage" class="btn_page">下一页</button>
            </div>
        </div>
        <div>
            <button id="btn_arrangeRoom">分配考场</button>
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
        <input type="hidden" id="examName" name="examName" value="${examName}">
    </form>
    <input type="hidden" id="totalPage" value="">
    <input type="hidden" id="userName" value="${sessionScope.userName}">
    <input type="hidden" id="name" value="${sessionScope.name}">
</div>
</body>
</html>

