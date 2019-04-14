<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/3
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximun-scale=1.0, user-scalable=no">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/auth.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.ui.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=e671a108fe7919776736fc2a06dbe257"></script>
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/js/zhidao.js" type="text/javascript" charset="UTF-8"></script>
    <style type="text/css">
        /*删除高德地图的logo*/
        .amap-logo {
            right: 0 !important;
            left: auto !important;
            display: none;
        }

        .amap-copyright {
            right: 70px !important;
            left: auto !important;
        }
    </style>

</head>
<body>
<jsp:include page="common.jsp"/>
<div class="send_msg-form">
    <form class="layui-form" id="add_msg">
        <div class="layui-form-item">
            <label class="layui-form-label" >输入框</label>
            <div class="layui-input-block">
                <input type="text" id="title" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">单选框</label>
            <div class="layui-input-block" id="addMsg-select">
                <input type="radio" name="msg_type" title="活动">
                <input type="radio" name="msg_type" title="签到" checked>
                <input type="radio" name="msg_type" title="提醒">
            </div>
        </div>
        <div class="layui-form-item" id="addMsg-switch">
            <label class="layui-form-label">定位</label>
            <div class="layui-input-block">
                <input  type="checkbox"  name="switch" lay-filter="switchDemo"  lay-skin="switch" lay-text="开启|关闭">
            </div>
        </div>
        <div class="layui-form-item" >
            <label class="layui-form-label">结束时间</label>
            <div class="layui-input-block">
                <div class="layui-input-inline" style="left:27%">
                    <input type="text" id="endtime" name="endtime" class="layui-input"  placeholder="yyyy-MM-dd HH:mm:ss">
                </div>
            </div>
        </div>
        <div class="layui-form-item" style="display: none">
            <label class="layui-form-label">位置</label>
            <div class="layui-input-block">
                <input type="text" name="location" id="location" placeholder="输入位置" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">地址</label>
            <div class="layui-input-block">
                <input type="text" name="address" style="background: #f2f2f2"  readonly="readonly" id="address" placeholder="输入位置" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">内容</label>
            <div class="layui-input-block">
                <textarea name="content" id="content"  placeholder="请输入内容" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block" id="addMsg-button">
                <button class="layui-btn"  id="addMsg-button-1"  lay-filter="formDemo" type="button" onclick="addMsg()" >提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<div class="get_map" id="get_map" >
    <div id='container' style="height:100%;width: 100%"></div>
    <div id="tip"></div>
</div>
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;
        //监听开关
        form.on('switch(switchDemo)',function (data) {
            var x=data.elem.checked;
            if (x===true){
                document.getElementById("get_map").style.display="inline";
                document.getElementById("address").style.background="white";
                document.getElementById("address").value='默认为当前所在位置';
                document.getElementById("get_map").style.display="true";
                $("#address").attr("readOnly",false);
                getLocation();
            }
            else{
                document.getElementById("address").style.background="#f2f2f2";
                $("#address").attr("readOnly","true");
                document.getElementById("address").value=null;
                document.getElementById("get_map").style.display="none";
            }
        });
    });
    layui.use('laydate',function () {
        var laydate=layui.laydate;
        laydate.render({
            elem: '#endtime',
            type: 'datetime',
            theme: '#204d74',
            min:'new Date()',
            value:new Date()
        });
    })
</script>
</body>
</html>
