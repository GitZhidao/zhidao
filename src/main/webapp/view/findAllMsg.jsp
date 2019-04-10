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
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/auth.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/js/jquery/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/js/zhidao.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body onload="allSendMsg()">
<jsp:include page="/view/common.jsp"/>
<div class="msg_list">
    <c:forEach var="msg" items="${msgs}">
        <%--<a href="${pageContext.request.contextPath}/msg/getMsg.do?msgId=${msg.msgId}" target="msgFrame">--%>
            <div class="msg">
                <div class="msg_title">
                    <label style="color: #5e5e5e">标题:</label>
                    <label>${msg.title}</label>
                </div>
                <div class="creatTime">
                    <label style="color: #5e5e5e">开始时间:</label>
                    <label>${msg.creatTime}</label>
                </div>
                <div class="endTime">
                    <label>结束时间</label>
                    <label>${msg.endtime}</label>
                </div>
                <%--<div class="delete_msg">--%>
                    <%--<a href="${pageContext.request.contextPath}/msg/deleteMsg.do?msgId=${msg.msgId}">删除</a>--%>
                <%--</div>;--%>
            </div>
        <%--</a>--%>
    </c:forEach>
</div>
</body>
</html>
