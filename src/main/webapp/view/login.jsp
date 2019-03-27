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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/auth.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/zhidao.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body>
<div class="lowin lowin-blue">
    <div class="lowin-brand">
        <img style="width: 100%;height: 100%;border-radius: 50%" src="${pageContext.request.contextPath}/images/newicon.jpg" alt="logo">
    </div>
    <div class="lowin-wrapper">
        <div class="lowin-box lowin-login">
            <div class="lowin-box-inner">
                <form>
                    <p>账户登录</p>
                    <div class="lowin-group">
                        <label>用户名<a href="#" class="login-back-link">Sign in?</a></label>
                        <input type="text"  name="username" id="username" autocomplete="username" required="required" class="lowin-input"  autofocus="autofocus">
                    </div>
                    <div class="lowin-group password-group">
                        <label>密码</label>
                        <input type="password" id="password" name="password" autocomplete="current-password"  required="required" class="lowin-input" >
                    </div>
                    <button class="lowin-btn login-btn" type="button" onclick="login()">
                        Sign In
                    </button>
                    <div class="text-foot">
                        点击注册 <a href="/view/regist.jsp" class="register-link">Register</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
