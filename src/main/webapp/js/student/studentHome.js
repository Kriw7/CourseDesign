$(function () {
//——————————————————————Nav—————————————————————
    //nav学生个人主页
    $("#nav_toStudentHome").click(function (e) {
        e.preventDefault();
        $("#form_toStudentHome").submit();
    })
    //nav可报名的考试列表
    $("#nav_toPermittedExamList").click(function (e) {
        e.preventDefault();
        $("#form_toPermittedExamList").submit();
    })
    //nav已经报名的考试
    $("#nav_toSignedExams").click(function (e) {
        e.preventDefault();
        $("#form_toSignedExams").submit();
    })
    //注销用户
    $("#btn_cancel").click(function () {
        logout();
    })
//——————————————————————功能—————————————————————
    loadFunction();


// ——————————————————函数部分————————————————————
    function loadFunction() {
        loadBasicInfo();
    }
    function loadBasicInfo() {
        var userName = $("#userName").val().trim();
        $.ajax({
            url:"/student/loadStudentBasicInfo.do",
            type:"post",
            data:{"userName":userName},
            success:function (result) {
                console.log(result);
                var info = result.data;
                $("#span_studentName").text(info.name);
                $("#span_studentAge").text(info.age);
                $("#span_studentGender").text(info.gender);
                $("#span_studentGrade").text(info.grade);
                $("#span_studentMajor").text(info.major);
                $("#span_studentClassOrder").text(info.classOrder);
            }
        })
    }
    function logout() {
        var ensure = confirm("确认退出登陆吗？");
        if (ensure){
            $("#form_logOut").submit();
        }
    }
})