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
        <h1 style="margin-left: 90px">信息管理</h1>
    </div>
    <div class="menu">
        <div class="menu_head">
            <div class="menu_head_1">用户:${user.username}</div>
            <div class="menu_head_2"></div>
        </div>
        <div id="menu_middle">
            <ul style="margin-left: 0px">
                <li class="item"><a  href="/user/userinfo.do"  target="_self">个人信息</a></li>
                <li class="item"><a href="/view/addMsg.jsp" target="_parent">添加信息</a></li>
                <li class="item"><a  href="/msg/findAllMsg.do" target="_self">所有信息</a></li>
                <li class="item"><a  href="/oldMsg/allOldMsg.do" target="_self">历史信息</a> </li>
                <li class="item"><a  href="/msg/getLineChart.do" target="_self" class="left_list">回收站</a></li>
            </ul>
            <div id="menu-separator">
                <hr />
            </div>
        </div>

            <div id="menu-foot">
                <a id="loginOut" class="loginOut" href="/user/loginOut.do">退出登录</a>
            </div>
    </div >

</div>