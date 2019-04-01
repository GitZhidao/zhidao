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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/auth.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.ui.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/zhidao.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body>
<div class="lowin lowin-blue">
    <div class="lowin-brand">
        <img style="width: 100%;height: 100%;border-radius: 50%" src="${pageContext.request.contextPath}/images/newicon.jpg" alt="logo">
    </div>
    <div class="lowin-wrapper">
        <div class="lowin-box lowin-register">
            <div class="lowin-box-inner">
                <form>
                    <p>创建你的账户</p>
                    <div class="lowin-group">
                        <label>Name</label>
                        <label for="username"></label><input type="text" name="username" id="username" autocomplete="name" required="required" class="lowin-input">
                    </div>
                    <div class="lowin-group">
                        <label>Password</label>
                        <label for="password"></label><input type="password" name="password" id="password" autocomplete="current-password" required="required" class="lowin-input">
                    </div>
                    <div class="lowin-group">
                        <label>email</label>
                        <label for="email"></label><input type="password" name="email" id="email" autocomplete="current-password" required="required" class="lowin-input">
                    </div>
                    <button class="lowin-btn" id="login_btn" type="button" onclick="register()">
                        Sign Up
                    </button>
                    <div class="text-foot">
                        已有账号？点击登录<a href="${pageContext.request.contextPath}/view/login.jsp" class="login-link">Login</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
