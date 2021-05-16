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
    //查看考试详情
    $(".a_examName").click(function (e) {
        e.preventDefault();
        $("#form_examDetail").submit();
    })
    //初始加载
    var currentPageNo = 1;
    var currentPageSize = 5;
    loadFunction(currentPageNo,currentPageSize);
    //分配考场
    $("#btn_arrangeRoom").click(function () {
        //判断人数
        var examNums = $("#exam_nums").text();
        if (examNums==0) {alert("该报名人数为0，无需分配考场。\n请考虑删除或重新设置考试。"); return false;}
        //判断教室选择
        var roomChecks =$("#table_arrangeRoom").find(".roomcheck");
        var selected = false;
        var currentNums = 0;
        $.each(roomChecks,function (index,element) {
            var target = $(element);
            if (target.prop("checked")) {
                var selectedNum = target.parent().parent().find(".roomSize").text();
                selected=true;
                currentNums=parseInt(currentNums) + parseInt(selectedNum);
            }
        })
        if (!selected) {alert("请至少选择一个教室作为考场!"); return false;}
        if (currentNums<examNums) {alert("当前选择的考场座位数还不足以支撑考试人数！\n请选择更多的教室或者更大的教室作为考场！");return  false;}
        //分配教室
        var ensure = confirm("确认这样分配教室吗？");
        if(ensure) $("#form_arrangeRoom").submit();
    })

    //上一页
    $("#btn_prevPage").click(function () {
        if (currentPageNo==1) alert("这已经是最前面一页了!");
        else{
            currentPageNo=currentPageNo-1;
            loadRoomByPage(currentPageNo,currentPageSize);
        }
    })
    //下一页
    $("#btn_nextPage").click(function () {
        var totalPageNo = $("#totalPage").val();
        if (totalPageNo==currentPageNo) alert("这已经是最后一页了！");
        else {
            currentPageNo = currentPageNo + 1;
            loadRoomByPage(currentPageNo,currentPageSize);
        }
    })
// ——————————————————函数部分————————————————————
    function loadFunction(pageNo,pageSize) {
        loadExamInfo();
        loadRoomByPage(pageNo,pageSize);
        loadTotalPageNo(pageSize);
    }
    function loadExamInfo() {
        var examName = $("#examName").val().trim();
        $.ajax({
            url:"/exam/loadOneByExamName.do",
            type:"post",
            data:{"examName":examName},
            success:function (result) {
                var examInfo = result.data;
                $("#exam_nums").text(examInfo.nums);
                $("#exam_beginTime").text(timeChange(examInfo.beginTime));
                $("#exam_endTime").text(timeChange(examInfo.endTime));
            }
        })
    }
    function loadRoomByPage(pageNo,pageSize) {
        $("#table_arrangeRoom").find(".OneRoom").remove();
        $.ajax({
            url:"/room/loadAllRoomByPage.do",
            type:"post",
            data:{"pageNo":pageNo,"pageSize":pageSize},
            success:function (result) {
                // console.log(result);
                $.each(result.data,function (index,element) {
                    var roomId = element.id;
                    var roomSize =element.size;
                    var roomPlace = element.place;
                    var roomStatus = element.status;
                    var operation = "";
                    if (roomStatus=="free") operation="<input type='checkbox' name='selectRoomId' class='roomcheck' value='" + roomId + "'></td>";
                    else operation="✖️";
                    var newRoom = "<tr class='OneRoom'>\n" +
                        "            <td><span>" + roomId + "</span></td>\n" +
                        "            <td><span class='roomSize'>" + roomSize + "</span></td>\n" +
                        "            <td><span>" + roomPlace + "</span></td>\n" +
                        "            <td><span>" + roomStatus + "</span></td>\n" +
                        "            <td>"  + operation + " </td>\n" +
                        "           </tr>";
                    $("#table_arrangeRoom").append(newRoom);
                })
            }
        })
    }
    function loadTotalPageNo(pageSize) {
        $.ajax({
            url:"/room/loadTotalPage.do",
            type:"post",
            data:{"pageSize":pageSize},
            success:function (result) {
                // console.log(result);
                $("#totalPage").val(result.data);
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