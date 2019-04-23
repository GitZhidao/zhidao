<%--
  Created by IntelliJ IDEA.

  Date: 2019/2/28
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>账户注册</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/auth.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.ui.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/js/jquery/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/zhidao.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body>
<div id="regist-content" class="lowin lowin-blue">
    <div class="lowin-brand">
        <img style="width: 100%;height: 100%;border-radius: 50%" src="${pageContext.request.contextPath}/images/newicon.jpg" alt="logo">
    </div>
    <div class="lowin-wrapper">
        <div class="lowin-box lowin-register">
            <div class="lowin-box-inner">
                <form>
                    <p>创建你的账户</p>
                    <div class="lowin-group">
                        <label>用户名</label>
                        </label><input type="text"  name="username" oninput="checkUsername()" id="regist-username" autocomplete="name" required="required" class="lowin-input">
                        <div style="position: absolute;left: 105%;width: 150px;top: 20%">
                            <i class="layui-icon layui-icon-face-cry" id="regist-icon" style="display:none ;font-size:20px;color: red;font-weight: 700;margin-right: 10px"></i>
                            <span  style="font-weight: 700;" id="regist-username-msg"></span>
                        </div>

                    </div>
                    <div class="lowin-group">
                        <label>密码</label>
                        <input type="password" name="password" oninput="checkPassword()" id="regist-password" autocomplete="current-password" required="required" class="lowin-input">
                        <div style="position: absolute;left: 105%;width: 300px;top: 35%">
                            <i class="layui-icon layui-icon-face-cry" id="regist-icon-2" style="display:none ;font-size:20px;color: red;font-weight: 700;margin-right: 10px"></i>
                            <span  style="font-weight: 700;font-family:'Segoe UI',sans-serif;" id="regist-password-msg"></span>
                        </div>
                    </div>
                    <div class="lowin-group">
                        <label>邮箱</label>
                        <label for="email"></label><input oninput="checkEmail()" type="email" name="email" id="email" autocomplete="current-password" required="required" class="lowin-input">
                    </div>
                    <div style="position: absolute;left: 105%;width: 300px;top: 51%">
                        <i class="layui-icon layui-icon-face-cry" id="regist-icon-3" style="display:none ;font-size:20px;color: red;font-weight: 700;margin-right: 10px"></i>
                        <span  style="font-weight: 700;" id="regist-email-msg"></span>
                    </div>
                    <div class="lowin-group">
                        <label>验证码</label>
                        <input  style="width: 50%" type="text" name="code" id="code" autocomplete="current-password"  class="lowin-input">
                        <button id="send-code"  type="button" onclick="sendCode()">发送验证码</button>
                        <button class="lowin-btn" id="regist-button" type="button">
                        注册
                    </button>
                    <div class="text-foot">
                        已有账号？点击登录<a href="${pageContext.request.contextPath}/login.jsp" class="login-link">Login</a>
                    </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
