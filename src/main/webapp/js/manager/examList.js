$(function () {
//——————————————————————Nav—————————————————————
    //nav首页
    $("#nav_toHome").click(function(e){
        e.preventDefault();
        $("#form_toManagerHome").submit();
    })
    //nav考试列表
    $("#nav_toExamList").click(function(e){
        e.preventDefault();
        $("#form_examList").submit();
    })
    //nav添加考试
    $("#nav_toAddExam").click(function(e){
        e.preventDefault();
        $("#form_addExam").submit();
    })
    //nav添加考场
    $("#nav_toAddRoom").click(function (e) {
        e.preventDefault();
        $("#form_addRoom").submit();
    })
    //注销用户
    $("#btn_cancel").click(function(){logout();})
//——————————————————————功能—————————————————————
    var currentPageNo = 1;
    var currentPageSize = 8;
    loadFunction(currentPageNo,currentPageSize);
    //点击查看具体的考试信息
    $("#table_totalExam").on("click",".a_examName",function (e) {
        e.preventDefault();
        var target = $(e.target);
        $("#examName").val(target.text());
        $("#form_examDetail").submit();
    })
    //上一页
    $("#btn_prevPage").click(function () {
        if (currentPageNo==1) alert("这已经是最前面一页了!");
        else{
            currentPageNo=currentPageNo-1;
            loadNewPage(currentPageNo,currentPageSize);
        }
    })
    //下一页
    $("#btn_nextPage").click(function () {
        var totalPageNo = $("#totalPage").val();
        if (totalPageNo==currentPageNo) alert("这已经是最后一页了！");
        else {
            currentPageNo = currentPageNo + 1;
            loadNewPage(currentPageNo,currentPageSize);
        }
    })
//——————————————————函数部分————————————————————
    function loadFunction(pageNo,pageSize) {
        var userName = $("#userName").val().trim();
        //加载所有的考试信息
        loadTotalPage(pageSize);
        loadNewPage(pageNo,pageSize);
    }
    function loadTotalPage(pageSize) {
        $.ajax({
            url:"/exam/loadTotalPage.do",
            type:"post",
            data:{"pageSize":pageSize},
            success:function (result) {
                if (result.success) $("#totalPage").val(result.data);
            }
        })
    }
    function loadNewPage(pageNo,pageSize) {
        $("#table_totalExam").find(".examSample").remove();
        $.ajax({
            url:"/exam/loadExamsByPage.do",
            type:"post",
            data:{"pageNo":pageNo,"pageSize":pageSize},
            success:function (result) {
                // console.log(result);
                $.each(result.data,function (index,element) {
                    var beginTime = timeChange(element.beginTime);
                    var endTime = timeChange(element.endTime);
                    var signBeginTime = timeChange(element.signBeginTime);
                    var signEndTime =timeChange(element.signEndTime);
                    var examType = element.type;
                    var examStatus = element.status;
                    var status = "";
                    if (examStatus=="open") status = "可报名";
                    else if (examStatus=="close") status="报名结束";
                    else if (examStatus=="show") status="已分配";
                    else status = "系统出差错";
                    var examName = element.name;
                    var examLevel = element.level;
                    var examNums = element.nums;
                    var newExam = "<tr class='examSample'>" +
                        "              <td>" + examType + "</td>\n" +
                        "              <td>" + examLevel + "</td>\n" +
                        "              <td><a href='javascript:void(0)' class='a_examName' title='查看详情'>" + examName + "</a></td>\n" +
                        "              <td>" + beginTime + "</td>\n" +
                        "              <td>" + endTime + "</td>\n" +
                        "              <td>" + signBeginTime + "</td>\n" +
                        "              <td>" + signEndTime + "</td>\n" +
                        "              <td>" + examNums + "</td>\n" +
                        "              <td>" + status + "</td></tr>";
                    $("#table_totalExam").append(newExam);
                })
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