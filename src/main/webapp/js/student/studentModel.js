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



// ——————————————————函数部分————————————————————
    function logout() {
        var ensure = confirm("确认退出登陆吗？");
        if (ensure){
            $("#form_logOut").submit();
        }
    }
})