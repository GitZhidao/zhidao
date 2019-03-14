<%@ page import="com.zhidao.common.ServerResponse" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/4
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="/css/auth.css">
    <link rel="stylesheet" href="/layui/css/layui.css">
</head>
<body>
<div class="lowin lowin-blue">
    <div class="lowin-brand">
        <img style="width: 100%;height: 100%;border-radius: 50%" src="/images/zhidao.png" alt="logo">
    </div>
    <div class="lowin-wrapper">
        <div class="lowin-box lowin-login">
            <div class="lowin-box-inner">
                <form action="/user/login.do" method="get">
                    <p>账户登录</p>
                    <div class="lowin-group">
                        <label>用户名<a href="#" class="login-back-link">Sign in?</a></label>
                        <input type="text"  name="username" autocomplete="username" required="required" class="lowin-input" id="username" autofocus="autofocus">
                    </div>
                    <div class="lowin-group password-group">
                        <label>密码</label>
                        <input type="password" name="password" autocomplete="current-password"  required="required" class="lowin-input" id="password">
                    </div>
                    <button class="lowin-btn login-btn" type="submit">
                        Sign In
                    </button>

                    <div class="text-foot">
                        点击注册 <a href="/regist.jsp" class="register-link">Register</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="/layui/layui.js"></script>
<script language="JavaScript">
    var msg="${serverResponse.msg}";
    window.onload=layui.use(['layer', 'form'], function(){
        var layer = layui.layer
            ,form = layui.form;
        if (msg.trim()){
            layer.msg(msg);
        }
    });
</script>
</body>
</html>
