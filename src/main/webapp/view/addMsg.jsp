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
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/auth.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.ui.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=e671a108fe7919776736fc2a06dbe257"></script>
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
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
    <p style="font-size: larger">添加信息</p>
    <form action="${pageContext.request.contextPath}/msg/addMsg.do"  method="get" class="form-horizontal m-t" id="commentForm">
        <div class="form-group">
            <label class="col-sm-3 control-label">标题：</label>
            <div class="col-sm-8">
                <input  id="cname"  name="title"  minlength="2" type="text" class="send_msg_input" name="title" required="required">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">内容：</label>
                <div class="col-sm-8">
            <textarea class="send_msg_input" name="msg" cols="40" required="required" rows="4"  style="OVERFLOW: hidden"></textarea>
                </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">开始时间：</label>
            <div class="col-sm-8">
                <input class="send_msg_input"  id="startime" name="creatTime"  required="" aria-required="true" ></input>
             </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">开始时间：</label>
            <div class="col-sm-8">
                <input class="send_msg_input"  id="endtime" name="creatTime"  required="" aria-required="true" ></input>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">附加文件：</label>
            <div class="col-sm-8">
                <input class="send_msg_input"  id="fileload" name="creatTime"  required="" aria-required="true" ></input>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">位置：</label>
            <div class="col-sm-8">
                <input class="send_msg_input"  id="local" name="creatTime"  required="" aria-required="true" ></input>
            </div>
        </div>
        <div>

            <div class="col-sm-4 col-sm-offset-3">
            <button class="btn btn-primary" type="submit">添加</button>
            </div>
        </div>
    </form>
</div>
<div class="getmap">
    <div id='container' style="height:100%;width: 100%"></div>
    <div id="tip"></div>
    <script type="text/javascript">
        var map, geolocation;
        //加载地图，调用浏览器定位服务
        map = new AMap.Map('container', {
            resizeEnable: true
        });
        map.plugin('AMap.Geolocation', function () {
            geolocation = new AMap.Geolocation({
                enableHighAccuracy: true,//是否使用高精度定位，默认:true
                timeout: 10000000,          //超过10秒后停止定位，默认：无穷大
                buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
                zoomToAccuracy: false,      //定位区域
                buttonPosition: 'RB'
            });
            map.addControl(geolocation);
            geolocation.getCurrentPosition();
            AMap.event.addListener(geolocation, 'complete', onComplete);//返回定位信息
            AMap.event.addListener(geolocation, 'error', onError);      //返回定位出错信息
        });
        //解析定位结果
        function onComplete(data) {
            var str = ['定位成功'];
            str.push('经度：' + data.position.getLng());
            str.push('纬度：' + data.position.getLat());
            str.push('精度：' + data.accuracy + ' 米');
            str.push('是否经过偏移：' + (data.isConverted ? '是' : '否'));
            document.getElementById('tip').innerHTML = str.join('<br>');
        }
        //解析定位错误信息
        function onError(data) {
            document.getElementById('tip').innerHTML = '定位失败';
        }
    </script>
</div>
</body>
</html>
