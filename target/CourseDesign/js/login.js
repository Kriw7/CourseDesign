$(function () {
    //聚焦到用户栏
    $("#userName").focus();

    //登陆失败的信息的检查
    var message = getValue("message");
    if (message!=null){
        alert(message);
        window.location.href="./login.jsp";
    }
    $("#btn_login").click(function(){
        login();
    })

    //回车监听
    $(document).keyup(function (event) {
        var key = event.which;
        if (key==13){
            event.preventDefault();
            login();
        }
    });

    //去注册
    $("#btn_register").click(function () {//页面跳转
        window.location.href="./register.jsp";
    })
    //返回首页
    $("#btn_index").click(function () {
        window.location.href="./index.jsp";
    })
//——————————————————函数区域————————————————————————————————
    function login() {
        var name =$("#userName").val().trim();
        var password = $("#password").val().trim();
        if (name==""){
            alert("请先输入用户名=～=，再登陆");
            $("#userName").focus();
        }else if (password==""){
            alert("密码不能为空-x-");
            $("#password").focus();
        }else
            $("#loginForm").submit();
    }
    //decodeURI 和encodeURI可以看作是相反作用的一对操作.
    //从URL当中提取因重定向ModelAndView自动添加的URL信息时，可以使用decodeURL来将其转化为UTF-8
    function getValue(name) {
        var reg = new RegExp("(^|&)"+name+"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r!=null) return decodeURI(r[2]);
        return  null;
    }
})