<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/4
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="content1">
    <div class="head">
        <div class="con">
            <img src="${pageContext.request.contextPath}/images/newicon.jpg" width="100%" height="100%">
        </div>
        <label  class="commone-title" id="common-title"></label>
    </div>
    <div class="menu">
        <div class="menu_head">
            <div class="menu_head_1">
                <ul class="layui-nav">
                    <li class="layui-nav-item">
                        <img src="${pageContext.request.contextPath}//t.cn/RCzsdCq" class="layui-nav-img">${user.username}
                        <dl class="layui-nav-child">
                            <dd><a href="userInform.jsp">修改信息</a></dd>
                            <%--<dd><a href="javascript:;">安全管理</a></dd>--%>
                            <dd><a onclick="loginOut()">退了</a></dd>
                        </dl>
                    </li>
                </ul>
            </div>
        </div>
        <div id="menu_middle">
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
                <li class="layui-nav-item ">
                    <a><span>发布</span></a>
                    <dl class="layui-nav-child">
                        <dd><a id="addSubject-href"><span>主题</span></a></dd>
                        <dd><a href="addMsg.jsp"><span>信息</span></a></dd>

                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a >我的主题</a>
                    <dl class="layui-nav-child">
                        <dd><a href="allSubject.jsp" id="allSendSubject-href"><span>发布的主题</span></a></dd>
                        <dd><a  href="allFocusMsg.jsp"><span>关注的主题</span></a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a id="focusSubject-href">关注主题</a></li>
                <li class="layui-nav-item"><a href="#">活动推荐</a></li>
            </ul>
            <div id="menu-separator">
                <hr/>
            </div>
        </div>
    </div >
</div>
