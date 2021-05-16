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
    //退选
    $("#table_signedExams").on("click",".btn_cancelSign",function (e) {
        var ensure = confirm("你确定要退选这场考试吗？");
        var target = $(e.target);
        if (ensure==true) cancelOldExam(target);
    })
//——————————————————————功能—————————————————————
    var currentPageNo = 1;
    var currentPageSize = 6;
    loadFunction(currentPageNo,currentPageSize);
    //上一页
    $("#btn_prevPage").click(function () {
        if (currentPageNo==1) alert("这已经是最前面一页了!");
        else{
            currentPageNo=currentPageNo-1;
            loadNewPageExam(currentPageNo,currentPageSize);
        }
    })
    //下一页
    $("#btn_nextPage").click(function () {
        var totalPageNo = $("#totalPage").val();
        if (totalPageNo==currentPageNo) alert("这已经是最后一页了！");
        else {
            currentPageNo = currentPageNo + 1;
            loadNewPageExam(currentPageNo,currentPageSize);
        }
    })

// ——————————————————函数部分————————————————————
    function loadFunction(pageNo,pageSize) {
        loadNewPageExam(pageNo,pageSize);
        loadTotalPage(pageSize);
    }
    function loadNewPageExam(pageNo,pageSize) {
        var userName = $("#userName").val().trim();
        $("#table_signedExams").find(".OneSignedExam").remove();
        $.ajax({
            url:"/student/loadSignedExams.do",
            type:"post",
            data:{"userName":userName,"pageNo":pageNo,"pageSize":pageSize},
            success:function (result) {
                // console.log(result);
                $.each(result.data,function (index,element) {
                    var beginTime = timeChange(element.beginTime);
                    var endTime = timeChange(element.endTime);
                    var examPlace = element.place;
                    var examType = element.type;
                    var examName = element.name;
                    var examLevel = element.level;
                    var signExam = "<tr class='OneSignedExam'>\n" +
                        "                <td> " + examType + "</td>\n" +
                        "                <td> " + examLevel + "</td>\n" +
                        "                <td><a href='javascript:void(0)' class='a_examName' title='查看详情'>" + examName + "</a></td>\n" +
                        "                <td> " + beginTime + "</td>\n" +
                        "                <td> " + endTime + "</td>\n" +
                        "                <td> " + examPlace + "</td>\n" +
                        "                <td><button class='btn_cancelSign'>退选</button></td></tr>";
                    $("#table_signedExams").append(signExam);
                })
            }
        })
    }
    function loadTotalPage(pageSize) {
        var userName = $("#userName").val().trim();
        $.ajax({
            url:"/student/loadTotalPageNo.do",
            type:"post",
            data:{"userName":userName,"pageSize":pageSize},
            success:function (result) {
                $("#totalPage").val(result.data);
            }
        })
    }
    function cancelOldExam(target) {
        var userName = $("#userName").val().trim();
        var examName = target.parent().parent().find(".a_examName").text();
        $.ajax({
            url:"/relation/cancelOldRelation.do",
            type:"post",
            data:{"userName":userName,"examName":examName},
            success:function (result) {
                alert(result.msg);
                if (result.success) window.location.reload();
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