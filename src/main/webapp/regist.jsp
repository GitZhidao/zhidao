<%--
  Created by IntelliJ IDEA.

  Date: 2019/2/28
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>账户注册</title>
    <link rel="stylesheet" type="text/css" href="/css/auth.css"/>
    <link rel="stylesheet" type="text/css" href="/css/css.css"/>
    <link rel="stylesheet" type="text/css" href="/css/jquery.ui.css"/>
    <script src="/layui/layui.js"></script>

</head>
<body>
<div class="lowin lowin-blue">
    <div class="lowin-brand">
        <img style="width: 100%;height: 100%;border-radius: 50%" src="/images/zhidao.png" alt="logo">
    </div>
    <div class="lowin-wrapper">
        <div class="lowin-box lowin-register">
            <div class="lowin-box-inner">
                <form action="/user/regist.do" method="post">
                    <p>创建你的账户</p>
                    <div class="lowin-group">
                        <label>Name</label>
                        <input type="text" name="username"  autocomplete="name" required="required" class="lowin-input">
                    </div>
                    <div class="lowin-group">
                        <label>Password</label>
                        <input type="password" name="password" autocomplete="current-password" required="required" class="lowin-input">
                    </div>
                    <div class="lowin-group">
                        <label>email</label>
                        <input type="password" name="email" autocomplete="current-password" required="required" class="lowin-input">
                    </div>
                    <button class="lowin-btn" type="submit">
                        Sign Up
                    </button>

                    <div class="text-foot">
                        已有账号？点击登录<a href="/login.jsp" class="login-link">Login</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery.ui.js"></script>
<script type="text/javascript" src="/js/moment.min.js"></script>
<script type="text/javascript" src="/js/hotel.search.js"></script>
<script type="text/javascript" src="/js/stay.js"></script>
<script language="JavaScript">
    var msg="${serverResponse.msg}";
    window.onload=layui.use(['layer', 'form'], function(){
        var layer = layui.layer
            ,form = layui.form;
        if (msg.trim()){
            layer.msg(msg)  ;
        }
    });
</script>
</body>
</html>
