<%--
  Created by IntelliJ IDEA.
  Date: 2019/3/3
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/auth.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.ui.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/zhidao.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body>
<jsp:include page="/view/common.jsp"/>
<div class="msg-form">
    <div class="lowin lowin-blue">
        <div class="lowin-brand">
            <img style="width: 100%;height: 100%;border-radius: 50%" src="${pageContext.request.contextPath}/images/newicon.jpg" alt="logo">
        </div>
        <div class="lowin-wrapper">
            <div class="lowin-box lowin-login">
                <div class="lowin-box-inner">
                    <form>
                        <p>修改密码</p>
                        <div class="lowin-group">
                            <label>用户名<a href="#" class="login-back-link">Sign in?</a></label>
                            <input type="text"  name="username" id="username" autocomplete="username" required="required" class="lowin-input"  autofocus="autofocus">
                        </div>
                        <div class="lowin-group password-group">
                            <label>旧密码</label>
                            <input type="password" id="password" name="password" autocomplete="current-password"  required="required" class="lowin-input" >
                        </div>
                        <div class="lowin-group password-group">
                            <label>新密码</label>
                            <input type="password" id="newpassword" name="password" autocomplete="current-password"  required="required" class="lowin-input" >
                        </div>
                        <button class="lowin-btn login-btn" type="button" onclick="login()">
                            修改
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
