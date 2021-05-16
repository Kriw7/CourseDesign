$(function () {
//——————————————————————Nav—————————————————————
    //nav首页
    $("#nav_toHome").click(function (e) {
        e.preventDefault();
        $("#form_toManagerHome").submit();
    })
    //nav考试列表
    $("#nav_toExamList").click(function (e) {
        e.preventDefault();
        $("#form_examList").submit();
    })
    //nav添加考试
    $("#nav_toAddExam").click(function (e) {
        e.preventDefault();
        $("#form_addExam").submit();
    })
    //nav添加考场
    $("#nav_toAddRoom").click(function (e) {
        e.preventDefault();
        $("#form_addRoom").submit();
    })
    //注销用户
    $("#btn_cancel").click(function () {
        logout();
    })
//——————————————————————功能—————————————————————
    loadFunction();
    //返回列表
    $("#btn_backList").click(function () {
        $("#form_examList").submit();
    })
    //删除考试
    $("#btn_deleteExam").click(function () {
        var examController = $("#examController").text();
        var currentManager = $("#name").val();
        if (examController!=currentManager) alert("您没有对该考试的操作权限，请联系对应的管理员~");
        else{
            var ensure = confirm("管理员"+currentManager+"，您确定要删除这条考试吗？请注意，相关信息也会被清空");
            if(ensure) deleteExam();
        }
    })
    //更新考试
    $("#btnArea").on("click","#btn_updateExam",function () {
        var examController = $("#examController").text();
        var currentManager = $("#name").val();
        if (examController!=currentManager) alert("您没有对该考试的操作权限，请联系对应的管理员~");
        else{
            $("#form_updateExam").submit();
        }
    })
    //安排考场
    $("#btnArea").on("click","#btn_arrangeRoom",function () {
        var examController = $("#examController").text();
        var currentManager = $("#name").val();
        if (examController!=currentManager) alert("您没有对该考试的操作权限，请联系对应的管理员~");
        else{
            $("#form_arrangeRoom").submit();
        }
    })
    //修改考场
    $("#btnArea").on("click","#btn_changeRoom",function () {
        var examController = $("#examController").text();
        var currentManager = $("#name").val();
        if (examController!=currentManager) alert("您没有对该考试的操作权限，请联系对应的管理员~");
        else{
            alert("修改考场内容还未完善.");
        }
    })

// ——————————————————函数部分————————————————————
    function loadFunction() {
        loadExamInfo();
    }
    function loadExamInfo() {
        var examName = $("#examName").val().trim();
        $.ajax({
            url:"/exam/loadOneByExamName.do",
            type:"post",
            data:{"examName":examName},
            success:function (result) {
                var exam = result.data;
                var examStatus = exam.status;
                $("#examController").text(exam.examController);
                $("#examType").text(exam.type);
                $("#examLevel").text(exam.level);
                $("#examNums").text(exam.nums);
                if (examStatus=="open") {//可报名时才可更新
                    $("#examStatus").text("可报名");
                    $("#btnArea").append(" <button class='btn_function' id='btn_updateExam'>更新考试</button>");
                }
                else if (examStatus=="close") {
                    $("#examStatus").text("报名结束");
                    $("#btnArea").append("<button class='btn_function' id='btn_arrangeRoom'>安排考场</button>");
                }
                else if (examStatus=="show") {//如果已经安排了考场，那么就
                    $("#examStatus").text("已安排考场-->");
                    loadRoomPlace(examName);
                    $("#btnArea").append("<button class='btn_function' id='btn_changeRoom'>修改考场</button>");
                }
                else $("#examStatus").text("未知领域w");
                $("#examMaxGrade").text(exam.maxGrade);
                $("#examMajors").text(exam.permittedMajors);
                $("#examBeginTime").text(timeChange(exam.beginTime));
                $("#examEndTime").text(timeChange(exam.endTime));
                $("#examSignBeginTime").text(timeChange(exam.signBeginTime));
                $("#examSignEndTime").text(timeChange(exam.signEndTime));
                $("#examContent").text(exam.content);
            }
        })
    }
    function loadRoomPlace(examName) {
        $.ajax({
            url:"/exam/loadRoomPlace.do",
            type:"post",
            data:{"examName":examName},
            success:function (result) {
                if (result.success){
                    var roomPlace = "<span> " + result.msg + " </span>";
                    $("#examStatus").parent().append(roomPlace);
                }else alert(result.msg);
            }
        })
    }
    function deleteExam() {
        var examName = $("#examName").val().trim();
        var userName = $("#userName").val().trim();
        $.ajax({
            url:"/exam/deleteExam.do",
            type:"post",
            data:{"examName":examName},
            success:function (result) {
                alert(result.msg);
                if (result.success) $("#form_examList").submit();
            }
        })
    }
    function timeChange(time) {
        var date = new Date();
        date.setTime(time);
        var year = date.getFullYear();
        var month = date.getMonth()+1<10?"0"+(date.getMonth()+1):date.getMonth()+1;
        var day = date.getDate()<10?"0"+date.getDate():date.getDate();
        var hour = date.getHours()<10?"0"+date.getHours():date.getHours();
        var minute = date.getMinutes()<10?"0"+date.getMinutes():date.getMinutes();
        var second = date.getSeconds()<10?"0"+date.getSeconds():date.getSeconds();
        var end =year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
        return end;
    }
    function logout() {
        var ensure = confirm("确认退出登陆吗？");
        if (ensure){
            $("#form_logOut").submit();
        }
    }
})