<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/12
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>关注的信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/auth.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/js/jquery/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/js/zhidao.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body>
<jsp:include page="/view/common.jsp"/>
<div class="subject-search" id="subject-search">
    <label>
        <input class="subject-search-input" id="subject-search-input" placeholder="输入搜索信息">
        <i class="layui-icon layui-icon-search" style=" position: absolute;right: 0px;font-size: 25px"></i>
    </label>
</div>
<div class="subject-list" id="focusSubject-list">
</div>
<div class="get_map" id="focus-subject-tishi">
    <span class="addSubject-tishi">点击主题查看详情</span>
</div>
<div class="msg-list" id="focus-msg-list">
</div>
<script>
    window.onload=allFocusSubject();
</script>
</body>
</html>
