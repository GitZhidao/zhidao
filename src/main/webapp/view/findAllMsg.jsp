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
    <title>我发送的信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/auth.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/js/jquery/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/js/zhidao.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body>
<jsp:include page="/view/common.jsp"/>
<div class="msg-search" id="msg-search">
    <label>
        <input class="msg-search-input" id="msg-search-input" placeholder="输入搜索信息">
        <i class="layui-icon layui-icon-search" style=" position: absolute;right: 0px;font-size: 25px"></i>
    </label>
</div>
<div class="msg-list" id="msg-list">
    <%--<jsp:useBean id="msgs" scope="session" type="java.util.List"/>--%>
    <c:forEach var="msg" items="${msgs}">
        <ul class="layui-timeline">
            <li class="layui-timeline-item">
                <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                <div class="layui-timeline-content layui-text">
                    <h3 class="layui-timeline-title" style="color: #eb7350;left: -200px;font-size: 15px">${msg.endtime}</h3>
                    <div class="layui-collapse" lay-accordion>
                        <div class="layui-colla-item">
                            <h2 class="layui-colla-title">
                                <i class="layui-icon layui-icon-list msg-icon" style="color: #ff3683;font-size: 25px"></i>
                                <label class="msg-title">${msg.title}</label>
                            </h2>
                            <div class="layui-colla-content">
                                <p class="msg-content">${msg.content}</p></div>
                        </div>
                    </div>
                </div>
            </li>
        </ul>
    </c:forEach>
</div>
<script>
    window.onload=allSendMsg();
    $(function () {
        $("#msg-search").click(function () {
            $(this).css("border-color",'#97a4ff');
        });
    });
    $(document).click(function(){
        $("#msg-search").css("border-color","rgba(126, 140, 130, 0.51)");
    });
    $("#msg-list").click(function(){
        $("#msg-search").css("border-color","rgba(126, 140, 130, 0.51)");
    });
    $("#msg-search").click(function(event){
        event.stopPropagation();
    });
</script>
</body>
</html>
