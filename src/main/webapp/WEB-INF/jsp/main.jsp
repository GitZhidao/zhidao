<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/2
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人清单</title>
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="/css/auth.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <script src="/layui/layui.js"></script>
    <script language="JavaScript">
        var msg="${serverResponse.msg}";
        layui.use(['layer', 'form'], function(){
            var layer = layui.layer
                ,form = layui.form;
            layer.msg(msg);
        });
    </script>
</head>
<body>
<jsp:include page="/common.jsp"/>
<div id="welcome">

</div>
</body>
</html>
