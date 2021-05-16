$(function () {
    //用户名重复判断
    $("#userName").change(function(){
        judgeUserName();
    })
    //密码重复判断
    $("#password2").change(function () {
        judgePassword();
    })
    $("#password").change(function () {
        var p1 = $("#password").val().trim();
        var p2 = $("#password2").val().trim();
        if (p1==p2)  $("#span_passwd2").text("");
    })
    //电子邮箱的判断
    $("#email").change(function () {
        judgeEmail();
    })
    // //表单提交。非空校验交给required属性了
    // $("#btn_register").click(function () {
    //     $("#registerForm").submit();
    // })
    //取消注册,返回登陆
    $("#btn_cancel").click(function () {
        var cancel = confirm("确定取消注册，返回登陆页面吗？");
        if (cancel==true){
            window.location.href="./login.jsp";
        }
    })
//——————————————————————函数区域——————————————————————————————
    function judgeUserName() {
        var userName = $("#userName").val().trim();
        if (userName!=""){
            $.ajax({
                url:"/user/jUserName.do",
                data:{"userName":userName},
                type:"post",
                success:function (result) {$("#span_userName").text(result.msg);}
            })
        }else
            $("#span_userName").text("");
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
    function judgeEmail() {
        var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
        var tempEmail = $("#email").val().trim();
        if (tempEmail!=""){//非空
            if (!reg.test(tempEmail)){//格式不对
                $("#span_email").text("邮箱格式不对～");
                $("#email").focus();
            }else{//格式正确
                $("#span_email").text("");
                //判断是否被使用
                $.ajax({
                    url: "/user/jEmail.do",
                    type:"post",
                    data:{"email":tempEmail},
                    success:function (result) {
                        $("#span_email").text(result.msg);
                    }
                })
            }
        }else//清空了 同时去掉提示
            $("#span_email").text("");
    }
})