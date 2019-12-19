<!DOCTYPE html>
<html lang="en">
<meta http-equiv="content-type" content="text/html;charset=UTF-8"/>

<head>
    <meta charset="UTF-8">

    <title>登录页</title>
    <#include "./common/common_header.ftl" />
    <link rel="stylesheet" href="/static/layuiadmin/style/login.css" media="all">
    <style>
        .login {
            height: 300px;
            width: 300px;
            padding: 20px;
            border-radius: 4px;
            position: absolute;
            left: 50%;
            top: 50%;
            margin: -150px 0 0 -150px;
            z-index: 99;
        }

        .login h1 {
            text-align: center;
            color: #fff;
            font-size: 24px;
            margin-bottom: 20px;
        }

        .bg-body {
            background: url("/static/images/xia.jpg") no-repeat center center;
        }
    </style>
</head>
<body class="bg-body">
<div class="login">
    <h1 style="">buff助手后台管理系统</h1>
    <form class="layui-form" action="/login" method="post">
        <div class="layui-form-item">
            <input class="layui-input" name="username" value="" placeholder="请输入手机号" lay-verify="required" type="text"
                   autocomplete="off" id="username">
        </div>
        <#--<div class="layui-form-item">
            <input class="layui-input" name="code" value="" placeholder="请输入验证码" lay-verify="required" type="text" id="bbb">
            <a href="javascript:;" onclick="sms()">获取手机验证码</a>
        </div>-->
        <#--<button class="layui-btn login_btn" id="btn" style="display:block;margin:0 auto">获取手机验证码</button>-->

        <div class="layui-form-item">
            <input class="layui-input" name="password" value="" placeholder="请输入密码" lay-verify="required" id="password"
                   type="password" autocomplete="off">
        </div>
    <#--<div class="layui-form-item">
        <div class="layui-input-block">
            <input type="radio" name="role" value="agent" title="代理人" checked>
            <input type="radio" name="role" value="admin" title="管理员">
        </div>
    </div>-->
        <div class="layui-form-item">
           <#-- <button class="layui-btn login_btn" id="btn1" style="display:block;margin:0 auto" lay-filter="login">登录</button>-->
            <button class="layui-btn login_btn" lay-submit="" lay-filter="login" style="display:block;margin:0 auto">登录</button>
        </div>
        <#--<script>
            var name = document.getElementById("username").value;
            layui.use(['form', 'layer', 'jquery'], function () {
                var form = layui.form,
                        layer = parent.layer === undefined ? layui.layer : parent.layer,
                        $ = layui.jquery;
                $(document).on('click', '#btn1', function () {
                    $.post("/sendsms", {"phone": name}, function (data) {
                        if (data.success)
                            layer.msg(data.message);
                    });
                });
            });

            function getMsgNum() {
                $.ajax({
                            url: '/sendsms', // 后台短信发送接口
                            type: 'POST',
                            dataType: 'json',
                            contentType: "application/json",
                            data: {'phone': name},
                            JSON.stringify(obj),
                success : function (data) {
                    if (data.success)
                        layer.msg(data.message);
                }
            }
        </script>-->
    </form>
</div>
<script type="text/javascript">
    layui.use(['form', 'layer', 'jquery'], function () {
        var form = layui.form;
        var $ = layui.jquery;
        form.on('submit(login)', function (data) {
            var name = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            /*var code = document.getElementById("code").value;*/
            $.post("/login/main", {"username":name,"password":password}, function (re) {
                if (re.success){
                    layer.msg(re.message);
                }
                console.log(re);
                layer.msg(re.message);
                /*if (data.code == 200) {
                    location.href = data.model.url;
                }*/
            });
            /*$.post("/login/main", data.field, function (data) {
                layer.msg(data.message);
                if (data.code == 200) {
                    location.href = data.model.url;
                }
            });*/
            /*return false;*/
        })
    });
</script>
<script>
    function sms() {
        var name = document.getElementById("username").value;
        $.post("/sendsms", {"phone": name}, function (data) {
            if (data.success) {
                layer.msg(data.message);
            }else {
                layer.msg(data.message);
            }
        });
    }

    layui.use(['form', 'layer', 'jquery'], function () {
        var form = layui.form,
                layer = parent.layer === undefined ? layui.layer : parent.layer,
                $ = layui.jquery;
        $(document).on('click', '#btn', function () {
            var name = document.getElementById("username").value;
            $.get("/sendsms?phone=" + name, function (data) {
                console.log(data);
                if (data.success)
                    layer.msg(data.message);
            });
            //$.get("/sendsms?phone=" + name);
        });
    });
</script>
</body>
</html>