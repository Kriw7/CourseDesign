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
    loadFunction();
    //日期选择插件
    $(".input_timepicker").datetimepicker({
        lang:"zh",
        showSecond:true,
        dateFormat:"yy-mm-dd",
        timeFormat:"HH:mm:ss"
    });
    //选择框all和其他选项的互斥
    $("#checkbox_all").change(function(){
        var status = $("#checkbox_all").prop("checked");
        if(status){//如果选中了取消按钮checkbox_major
            $(".checkbox_major").removeAttr("checked");
        }
    })
    $("#majorList").on("click",".checkbox_major",function(e){
        var status = $(e.target).prop("checked");
        var allStatus  = $("#checkbox_all").prop("checked");
        if(status && allStatus){
            $("#checkbox_all").prop("checked",false);
        }
        if(!status){//全空时把ALL加上
            var empty = true;
            $.each($(".checkbox_major"),function(index,element){
                var target = $(element);
                if(target.prop("checked")) empty=false;
            })
            if(empty){//确认为空，加上all
                $("#checkbox_all").prop("checked",true);
            }
        }
    })
    //提交前的输入值检测
    $("#btn_addExam").click(function () {
        if (judgeEmpty() && judgeLevel() &&judgeTime() &&judgeContentLength() ) $("#form_addNewExam").submit();
    })

//——————————————————函数部分————————————————————
    function loadFunction() {
        loadMajors();
    }
    function loadMajors() {
        $.ajax({
            url:"/student/loadMajors.do",
            type:"post",
            data:{},
            success:function (result) {
                var size = Object.keys(result.data).length+1;
                var count = 1;
                $.each(result.data,function (index,element) {
                    var majorName = element;
                    var newMajor = "<label>" + majorName + "<input name='permittedMajors' type='checkbox' value='" + majorName + "' class='checkbox_major'></label>";
                    $("#majorList").append(newMajor);
                    count++;
                    if (size>6 && count>Math.floor(size/count)) {
                        $("#majorList").append("<br/>");
                        count=0;
                    }
                })
            }
        })
    }
    function logout() {
        var ensure = confirm("确认退出登陆吗？");
        if (ensure){
            $("#form_logOut").submit();
        }
    }
    function judgeContentLength() {
        var str = $("#examContent").val();
        var len = str.length;
        if (len>250) {
            alert("字数太多了！");
            $("#examContent").focus();
            return false;
        }
        return true;
    }
    function judgeLevel() {//需要输入数字
        var level = $("#examLevel").val().trim();
        if (level!=""){
            if (isNaN(level)){//不是数字
                alert("请在考试等级栏输入数字！");
                $("#examLevel").focus();
                return false;
            }
        }
        return true;
    }
    function judgeTime() {//判断时间是否正确
        var Btime = $("#examBeginTime").val().trim();
        var Etime = $("#examEndTime").val().trim();
        var SBtime = $("#examSignBeginTime").val().trim();
        var SEtime = $("#examSignEndTime").val().trim();
        if (Btime!="" && Etime!=""){
            if(Btime>Etime){
                alert("请设置正确的考试时间。考试结束时间应该比考试开始时间迟。");
                $("#examEndTime").focus();
                return false;
            }
        }
        if(SBtime!="" && SEtime!=""){
            if(SBtime>SEtime){
                alert("请设置正确的报名考试时间。考试报名结束时间应该比考试报名开始时间迟。");
                $("#examSignEndTime").focus();
                return false;
            }
        }
        if(Btime!="" && SEtime!=""){
            if(SEtime>Btime){
                alert("请设置正确的报名考试时间。考试报名结束时间应该比考试开始时间早。\n请提前报名结束时间 或 延后考试时间");
                $("#examSignEndTime").focus();
                return false;
            }
        }
        if (Btime!="" && Etime!="" && SBtime!="" && SEtime!=""){
            if ((Btime<Etime) && (SBtime<SEtime) && (SEtime<Btime)) return true;
        }
        return false;
    }
    function judgeEmpty() {
        var type =  $("#examType").val().trim();
        var level = $("#examLevel").val().trim();
        var name = $("#examName").val().trim();
        var Btime = $("#examBeginTime").val().trim();
        var Etime = $("#examEndTime").val().trim();
        var SBtime = $("#examSignBeginTime").val().trim();
        var SEtime = $("#examSignEndTime").val().trim();
        var content = $("#examContent").val().trim();
        if (type==""){
            alert("考试类型不能为空！");
            $("#examType").focus();
            return false;
        }else if (level==""){
            alert("考试等级不能为空！");
            $("#examLevel").focus();
            return false;
        }else if (name==""){
            alert("考试名称不能为空！");
            $("#examName").focus();
            return false;
        }else if (Btime==""){
            alert("考试开始时间不能为空！");
            $("#examBeginTime").focus();
            return false;
        }else if (Etime==""){
            alert("考试结束时间不能为空！");
            $("#examEndTime").focus();
            return false;
        }else if (SBtime==""){
            alert("报名开始时间不能为空！");
            $("#examSignBeginTime").focus();
            return false;
        }else if (SEtime==""){
            alert("报名结束时间不能为空！");
            $("#examSignEndTime").focus();
            return false;
        }else if (content==""){
            alert("考试内容不能为空！");
            $("#examContent").focus();
            return false;
        }
        return true;
    }
})