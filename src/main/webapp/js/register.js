$(function () {
    //添加年龄的选择
    for(var i = 15;i<31;i++){
        var newOption = "<option value='" + i + "'>" + i + "</option>";
        $("#select_age").append(newOption);
    }
    //用户名重复判断
    $("#userName").change(function(){
        judgeUserName();
    })
    //密码重复判断
    $("#password2").change(function () {
        judgePassword();
    })
    //清空处理
    $("#password").change(function () {
        var p1 = $("#password").val().trim();
        var p2 = $("#password2").val().trim();
        if (p1==p2)  $("#span_passwd2").text("");
    })
    //取消注册,返回登陆
    $("#btn_cancel").click(function () {
        var cancel = confirm("确定取消注册，返回登陆页面吗？");
        if (cancel==true){
            window.location.href="./login.jsp";
        }
    })
    //登陆,需要检验一下用户名是否重复
    $("#btn_register").click(function (e) {
        if (judgeEmpty()){//非空
            var judgeResult = $("#jUserNameResult").val();
            if (judgeResult==1) {
                alert("当前用户名已经被使用了");
            }else $("#registerForm").submit();
        }
    })

//——————————————————————函数区域——————————————————————————————
    function judgeUserName() {
        var userName = $("#userName").val().trim();
        if (userName!=""){
            $.ajax({
                url:"/student/jUserName.do",
                data:{"userName":userName},
                type:"post",
                success:function (result) {
                    $("#span_userName").text(result.msg);
                    $("#jUserNameResult").val(result.data);
                }
            })
        }else{
            $("#span_userName").text("");
        }
    }
    function judgePassword() {
        var p1 = $("#password").val().trim();
        var p2 = $("#password2").val().trim();
        if (p1!=p2){
            $("#span_passwd2").text("两次输入的密码不一致！");
            $("#password2").focus();
        }else
            $("#span_passwd2").text("");
    }
    function judgeEmpty() {
        var username = $("#userName").val().trim();
        var password1 = $("#password").val().trim();
        var password2 = $("#password2").val().trim();
        var name = $("#name").val().trim();
        var major = $("#major").val().trim();
        if (username=="") {
            alert("用户名不能为空");
            return false;
        }else if (password1==""){
            alert("密码不能为空");
            return false;
        }else if(password2==""){
            alert("请重复输入密码！");
            return false;
        }else if (name==""){
            alert("真 名 告 破 ！");
            return false;
        }else if (major==""){
            alert("请填写专业信息~");
            return false;
        }
        return true;
    }
})