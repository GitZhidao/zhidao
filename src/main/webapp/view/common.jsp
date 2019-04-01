<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/4
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="content">
    <div class="head">
        <div class="con">
            <img src="/images/newicon.jpg" width="100%" height="100%">
        </div>
        <h1 style="margin-left: 90px">Code is everything</h1>
    </div>
    <div class="menu">
        <div class="menu_head">
            <div class="menu_head_1">用户:${user.username}</div>
            <div class="menu_head_2"></div>
        </div>
        <div id="menu_middle">
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="addMsg.jsp">发布信息</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:">活动</a></dd>
                        <dd><a href="javascript:">签到</a></dd>
                        <dd><a href="">提醒</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="userInform.jsp">我的信息</a>
                </li>
                <li class="layui-nav-item"><a href="">推荐</a></li>
                <li class="layui-nav-item"><a href="userInform.jsp">个人信息</a></li>
            </ul>
            <div id="menu-separator">
                <hr />
            </div>
        </div>

            <div id="menu-foot">
                <button id="loginOut" class="loginOut" type="button" onclick="loginOut()">退出登录</button>
            </div>
    </div >

</div>