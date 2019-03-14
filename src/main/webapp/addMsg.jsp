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
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/auth.css"/>
    <link rel="stylesheet" type="text/css" href="/css/css.css"/>
    <link rel="stylesheet" type="text/css" href="/css/jquery.ui.css"/>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <script src="/layui/layui.js"></script>

</head>
<body>
<jsp:include page="common.jsp"/>
<div class="msg-form">
    <form action="/msg/addMsg.do"  method="get" class="form-horizontal m-t" id="commentForm">
        <div class="form-group">
            <label class="col-sm-3 control-label">标题：</label>
            <div class="col-sm-8">
                <input  style="text-align:center;width:300px;border-color:black;border:1px solid;border-radius: 4px;padding: 8px" id="cname"  name="title"  minlength="2" type="text" class="form-control" name="title" required="required">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">内容：</label>
                <div class="col-sm-8">
            <textarea style="width: 300px;height: 100px;padding:2px;border-color:black;border:1px solid;border-radius: 4px" name="msg" cols="40" required="required" rows="4"  style="OVERFLOW: hidden"></textarea>
                </div>
        </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">开始时间：</label>
                <div class="col-sm-8">
                    <input style="width: 300px;padding:8px;border-color:black;border:1px solid;border-radius: 4px;" id="startDate" name="creatTime" class="form-control" required="" aria-required="true" ></input>
                 </div>
            </div>
        <div>
            <label style="margin-left: -7px" class="col-sm-3 control-label">提醒时间：</label></br>
            <input style="margin-left:110px;margin-top:-25px;width: 300px;padding:8px;border-color:black;border:1px solid;border-radius: 4px;" id="endDate" name="endtime" required="required" >
            </div>
            <div class="form-group">
            <div class="col-sm-4 col-sm-offset-3">
            <button class="btn btn-primary" type="submit">添加</button>
            </div>
        </div>
    </form>
    <form action="/msg/addMsgByExcel.do"  enctype="multipart/form-data" method="post" class="form-horizontal m-t" id="fileForm" novalidate="novalidate">
        <label style="margin-left: -7px" class="col-sm-3 control-label">通过文件上传：</label></br>
        <input style="margin-left: 120px" type="file" name="file"  id="file" value="请选择文件">
        <div class="form-group">
            <div class="col-sm-4 col-sm-offset-3">
                <button style="margin-left:-40px "  class="btn btn-primary" onclick="importUsers()" type="submit">上传</button>
            </div>
        </div>
    </form>
</div>

<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery.ui.js"></script>
<script type="text/javascript" src="/js/moment.min.js"></script>
<script type="text/javascript" src="/js/hotel.search.js"></script>
<script type="text/javascript" src="/js/stay.js"></script>
<script language="JavaScript">
    function importUsers(){
        var FormDatas=new FormData($("#fileForm")[0]);
        var fileName=$("#file").val();
        if(fileName == '') {
            alert('请选择文件！', {
                icon: MSG_CHECK,
                time: MSG_TIME
            });
            return false;
        }
        var fileType = (fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length)).toLowerCase();
        if (fileType != 'xlsx') {
            alert('文件格式不正确！',{
                icon:MSG_CHECK,
                time:MSG_TIME
            });
            return false;
        }
        $.ajax({
            type:'post',
            url:'',
            async : false,
            cache : false,
            contentType : false,
            processData : false,
            data:FormDatas,
            success: function(data){
                if(data == "error"){
                    layer.msg("文件导入失败，请重新上传！", {
                        icon: OPER_SB,
                        shade: [0.3, '#393D49'], // 透明度  颜色
                        time:5000
                    });
                    return false;
                }else{
                    layer.msg("文件导入成功！", {
                        icon: OPER_CG,
                        shade: [0.3, '#393D49'], // 透明度  颜色
                        time:5000
                    });
                    window.location.reload();
                    return false;
                }
            },
            error : function(data){
                console.log(data.msg);
            }
        });
    }
</script>
</body>
</html>
