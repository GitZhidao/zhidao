layui.use('element',function () {
    var element = layui.element;
    var isShow = true;
});

$(function (){
        var layer=layui.layer,colorpicker=layui.colorpicker,$ = layui.$,form=layui.form;
        $("#login_btn").click(function () {
            login();
        });
        $("#addSubject-href").click(function () {
            addSubject();
        });
        $("#focusSubject-href").click(function () {
            focusSubject();
        });
        $("#addMsg-button-1").click(function () {
            addMsg();
        });
});

function register(){
    layui.use('layer',function () {
        var index=layer.load();
        var user={
            "username":$("#username").val(),
            "password":$("#password").val(),
            "email":$("#email").val()
        };
        $.ajax({
            url:"../user/register.do",
            type:"POST",
            data:JSON.stringify(user),
            contentType:"application/json",
            async: true,
            error:function(){
                layer.close(index);
                layer.alert("注册失败",{icon:5});
            },
            success:function (data) {
                layer.close(index);
                if (data.status===0){
                    layer.alert("注册成功");
                }
                else
                {
                    layer.alert(data.msg,{icon:5});
                }
            }
        });
    })
}

function login(){
    layui.use('layer',function () {
        var layer=layui.layer;
        layer.ready(function(){
            var index=layer.load();
            var user={
                "username":$("#username").val(),
                "password":$("#password").val()
            };
            $.ajax({
                url:"../user/login.do",
                type:"POST",
                data:JSON.stringify(user),
                contentType:"application/json",
                async: true,
                error:function(){
                    layer.close(index);
                    layer.msg("登录失败");
                },
                success:(function (data) {
                    layer.close(index);
                    if (data.status===0){
                        window.location.href='/view/main.jsp';
                    }
                    else {
                        layer.alert(data.msg, {icon: 5});
                    }
                })
            });
        });

    })
}

function loginOut() {
    $.ajax({
        url:"../user/loginOut.do",
        type:"Get",
        contentType:"application/json",
        error:function(){
            alert("失败");
        },
        success:function (data) {
          window.location.href="../login.jsp";
        }
    })
}

function updateUserInfo() {
    var index=layer.load(1);
    var username=$("#username").val();
    var password=$("#password").val();
    var newPassword=$("#newPassword").val();
    $.ajax({
        url:"../user/updateUser.do",
        type:"POST",
        data:{"username":username,"password":password,"newPassword":newPassword},
        dataType:"json",
        error:function () {
            layer.alert("修改失败");
        },
        success:function (date) {
            if(date.status===2){
                layer.alert(date.msg);
                window.location.href="../login.jsp";

            }
            if (date.status===0)
            {
                window.location.href="../login.jsp";
                layer.alert("修改成功");
            }
            else {
                layer.alert("修改失败");
            }
        }
    })
}

function getLocation() {
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
        document.getElementById("location").value=data.position.getLng()+","+data.position.getLat()
        document.getElementById('tip').innerHTML = str.join('<br>');
    }
    //解析定位错误信息
    function onError(data) {
        document.getElementById('tip').innerHTML = '定位失败';
    }
    var geocoder,marker;
    function regeoCode() {
        if(!geocoder){
            geocoder = new AMap.Geocoder({
                city: "010", //城市设为北京，默认：“全国”
                radius: 1000 //范围，默认：500
            });
        }
        var location  = document.getElementById('location').value.split(',');
        if(!marker){
            marker = new AMap.Marker();
            map.add(marker);
        }
        marker.setPosition(location);

        geocoder.getAddress(location, function(status, result) {
            if (status === 'complete'&&result.regeocode) {
                var address = result.regeocode.formattedAddress;
                document.getElementById("address").value = address;
            }else{alert(JSON.stringify(result))}
        });
    }


    map.on('click',function(e){
        document.getElementById('location').value = e.lnglat;
        regeoCode();
    });
    document.getElementById("regeo").onclick = regeoCode;
    document.getElementById('location').onkeydown = function(e) {
        if (e.keyCode === 13) {
            regeoCode();
            return false;
        }
        return true;
    };
    window.onload=regeoCode();
}

function addMsg() {
    layui.use('layer',function () {
        var layer=layui.layer;
        var msg={
            "title":$("#title").val(),
            "location":$("#location").val(),
            "endtime":$("#endtime").val(),
            "content":$("#content").val(),
            "subid":$('#subject-select option:selected').val()
        };
        $.ajax({
            url:"../msg/sendMsg.do",
            type:"POST",
            data:JSON.stringify(msg),
            contentType:"application/json",
            async: true,
            error:function () {
                layer.alert("error");
            },
            success:function (data) {
                if(data.status===2){
                    layer.msg(data.msg);
                    window.location.href="../login.jsp";
                }
                if(data.status===0){
                    layer.msg(data.msg);
                    document.getElementById("add_msg").reset();
                }
                else {
                    layer.msg(data.msg);
                }
            }
        });
    })

}

function allMsg(i) {
    layui.use(['layer','element'],function () {
        var layer=layui.layer;
        var element=layui.element;
        var code=$("#label"+i).text();
        $.ajax({
            url:"../msg/allMsgByCode.do",
            type:"POST",
            data:{"code":code},
            error:function () {
                alert("error");
            },
            success:function (data) {
                $("#msg-list").empty();
                document.getElementById("subject-tishi").style.display="none";
                $.each(data.data,function (i,item) {
                    $("#msg-list").append(
                        "<ul class=\"layui-timeline\">"+
                        "<li class=\"layui-timeline-item\" style=\"margin-right: 15%\">"+
                        "<i class=\"layui-icon layui-timeline-axis\">&#xe63f;</i>"+
                        "<div class=\"layui-timeline-content layui-text\">"+
                        "<h3 class=\"layui-timeline-title\">"+item.endtime+"</h3>"+
                        "<div class=\"layui-collapse\">"+
                        "<div class=\"layui-colla-item\">"+
                        "<h2 class=\"layui-colla-title\">"+item.title+
                        "<i class=\"layui-icon layui-icon-reply-fill\" style=\"position: absolute;left: 10px\"></i>"+
                        "</h2>"+
                        "<div class=\"layui-colla-content layui-show\">"+item.content+"</div>"+
                        "</div>"+"</div>"+"</div>"+"</li>"+"</ul>"
                    )
                })
            }
        })
    })
}

function focusSubject() {
    layui.use('layer',function () {
        var layer=layui.layer;
        layer.prompt({
            title: '关注主题',
            placeholder:'输入主题编号',
            offset:['40%', '40%']
        }, function(val, index){
            var category=$("#categoryname").val();
            $.ajax({
                url:"../getSubject/focusSubject.do",
                type:"POST",
                data:{"code":val},
                error:function () {
                    layer.msg("error");
                },
                success:function (data) {
                    layer.msg(data.msg);
                    if (data.status===2){
                        window.location.href="../login.jsp";
                    }
                    if (data.status===0) {
                        layer.close(index);
                    }
                }
            });
        });
    });
}

function allSendSubject() {
    layui.use('layer',function () {
        var index=layer.load();
        $("#common-title").html("所有主题");
        $.ajax({
            url:"../subject/allSendSubject.do",
            type:"POST",
            async: false,
            error:function () {
                layer.close(index);
                alert("error");
            },
            success:function (data) {
                layer.close(index);
               $.each(data.data,function (i,item) {
                   $("#subject-list").append(
                       "<li class=\"layui-timeline-item\">"+
                        "<div class=\"layui-timeline-content layui-text\" >"
                           +"<div  onclick=\"allMsg("+i+")\" class=\"layui-collapse\" lay-accordion>"
                               +"<h2  class=\"layui-colla-title\">"
                               +"<i class=\"layui-icon layui-icon-template-1 subject-icon\" style=\"color: #ff3683;font-size: 25px\"></i>"
                               +"<label class=\"subject-title\">"+item.subtitle+"</label>"
                               +"<label id=\"label"+i+"\"  class=\"subject-code\">"+item.code+"</label>"
                               +"</h2>"+
                              "</div>"+
                       "</div>"+"</li>"
                   );
               })
            }
        })
    })
}

function showSendSubject() {
    layui.use('layer',function () {
        $("#common-title").html("添加信息");
        var index=layer.load();
        $.ajax({
            url:"../subject/allSendSubject.do",
            type:"POST",
            async: false,
            error:function () {
                layer.close(index);
                alert("error");
            },
            success:function (data) {
                layer.close(index);
                $.each(data.data,function (i,item) {
                    $("#subject-select").append(
                        "<option value='"+item.subid+"'>"+item.subtitle+"</option>"
                    );
                })
            }
        })
    })
}

function addSubject() {
    layui.use('layer',function () {
        var layer=layui.layer;
        layer.prompt({
            type:1,
            title: '发布主题',
            placeholder:'输入主题内容',
            offset:['30%', '40%'],
            area:["30%"]
        }, function(val, index){
            $.ajax({
                url:"../subject/addSubject.do",
                type:"POST",
                data:{"subtitle":val},
                error:function () {
                    layer.msg("error");
                },
                success:function (data) {
                    layer.alert(data.msg);
                    if (data.status===2){
                        window.location.href="../login.jsp";
                    }
                    if (data.status===0) {
                        layer.close(index);
                    }
                }
            });
        });
        $(".layui-layer-content").append("<br/><input type=\"text\" name=\"categoryname\" id= \"categoryname\" class=\"layui-input\" placeholder=\"类别\"/>");
    })
}

