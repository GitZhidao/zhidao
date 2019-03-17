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
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/auth.css"/>
    <link rel="stylesheet" type="text/css" href="/css/css.css"/>
    <link rel="stylesheet" type="text/css" href="/css/jquery.ui.css"/>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <script src="/layui/layui.js"></script>

</head>
<body>
<jsp:include page="/common.jsp"/>
<div class="msg-form">
    <form action="/user/updateUser.do"  method="post" class="form-horizontal m-t" id="commentForm">
        <div class="form-group">
            <label class="col-sm-3 control-label">姓名：</label>
            <div class="col-sm-8">
                <input  style="text-align:center;width:300px;border-color:black;border:1px solid;border-radius: 4px;padding: 8px" id="cname"  required="required" name="username"  minlength="2" type="text" class="form-control" name="title" value="${user.username}">
            </div>
        </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">密码：</label>
                <div class="col-sm-8">
                    <input type="password"  value="${user.password}" style="text-align:center;width: 300px;padding:8px;border-color:black;border:1px solid;border-radius: 4px;" id="startDate" name="password" class="form-control" required="required" aria-required="true" ></input>
                 </div>
            </div>
            <div class="form-group">
            <div class="col-sm-4 col-sm-offset-3">
            <button class="btn btn-primary" type="submit">修改</button>
            </div>
        </div>
    </form>
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/jquery.ui.js"></script>
    <script type="text/javascript" src="/js/moment.min.js"></script>
    <script type="text/javascript" src="/js/hotel.search.js"></script>
    <script type="text/javascript" src="/js/stay.js"></script>
</div>
</body>
</html>
