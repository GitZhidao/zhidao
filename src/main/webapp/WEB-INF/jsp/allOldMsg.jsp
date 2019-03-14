<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/7
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>以前消息</title>
</head>
<body>
<link rel="stylesheet" href="/css/main.css">
<link rel="stylesheet" href="/css/auth.css">
<link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
<jsp:include page="/common.jsp"/>
<div class="msg_list">
    <c:forEach var="oldMsg" items="${oldMsgs}">
            <div class="msg">
                <div class="msg_title">
                    <label style="color: #5e5e5e">标题:</label>
                    <label>${oldMsg.title}</label>
                </div>
                <div class="creatTime">
                    <label style="color: #5e5e5e">开始时间:</label>
                    <label>${oldMsg.createtime}</label>
                </div>
                <div class="endTime">
                    <label>结束时间</label>
                    <label>${oldMsg.endtime}</label>
                </div>
                <div class="delete_msg">
                    <a href="/m.do?oldMsgId=${oldMsg.oldId}">删除</a>
                </div>
            </div>
    </c:forEach>
</div>
</body>
</html>
