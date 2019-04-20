<%--suppress ALL --%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/6
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>我发布的主题</title>
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
<div class="subject-list" id="subject-list">
</div>
<div class="get_map" id="subject-tishi">
    <span class="addSubject-tishi">点击主题查看详情</span>
</div>
<div class="msg-list" id="msg-list">
</div>
<script>
    $(function () {
        $(".subject-search").click(function () {
            $(this).css("border-color",'#97a4ff');
        });
    });
    $(document).click(function(){
        $(".subject-search").css("border-color","rgba(126, 140, 130, 0.51)");
    });
    $("#subject-list").click(function(){
        $(".subject-search").css("border-color","rgba(126, 140, 130, 0.51)");
    });
    $(".subject-search").click(function(event){
        event.stopPropagation();
    });
    window.onload=allSendSubject();
</script>
</body>
</html>
