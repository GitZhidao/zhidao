layui.use('element',function () {
    var element = layui.element;
    var isShow = true;
});

$(function (){
        var layer=layui.layer,colorpicker=layui.colorpicker,$ = layui.$,form=layui.form;
        $("#login_btn").click(function () {
            login();
        });
         $("#regist-button").click(function () {
            register();
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

function checkPassword() {
    var flag=false,password=$("#regist-password").val();

    if (password.trim()===""){
        $("#regist-icon-2").addClass("layui-icon-face-cry").removeClass("layui-icon-face-smile").css({"display":"inline"});
        $("#regist-password-msg").html("密码不能为空").css({"color":"red"});
        flag=false;
    }
    else if (!/^(\w){6,20}$/.test(password.trim())){
        $("#regist-icon-2").addClass("layui-icon-face-cry").removeClass("layui-icon-face-smile").css({"display":"inline","color":"red"});
        $("#regist-password-msg").html("只能数字，字母下划线，6-15").css({"color":"red"});
        flag=false;
    }
    else {
        $("#regist-icon-2").addClass("layui-icon-face-smile").removeClass("layui-icon-face-cry").css({"color":"green"});
        $('#regist-password-msg').html("ok").css({"color":"green"});
        flag=true;
    }
}

function checkUsername() {
    var username=$("#regist-username").val();
    var flag=false;
    if (username===""){
        $("#regist-icon").addClass("layui-icon-face-cry").removeClass("layui-icon-face-smile").css({"display":"inline","color":"red"});
        $("#regist-username-msg").html("用户名不能为空").css({"color":"red"});
        flag=false;
    }
    else if (!/^(0|86|17951)?(13[0-9]|15[012356789]|166|17[3678]|18[0-9]|14[57])[0-9]{8}$/.test(username)){
        $("#regist-icon").css({"display":"inline","color":"red"});
        $('#regist-username-msg').html("请输入正确手机号").css({"color":"red"});
        flag=false;
    }
    else {
        $("#regist-icon").addClass("layui-icon-face-smile").removeClass("layui-icon-face-cry").css({"color":"green"});
        $('#regist-username-msg').html("ok").css({"color":"green"});
        flag=true;
    }
    return flag;
}

function checkEmail() {
    var email=$("#email").val();
    var flag=false;
    if (email===""){
        $("#regist-icon-3").addClass("layui-icon-face-cry").removeClass("layui-icon-face-smile").css({"display":"inline","color":"red"});
        $("#regist-username-msg").html("邮箱不能为空").css({"color":"red"});
        flag=false;
    }
    else if (!/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/.test(email)){
        $("#regist-icon-3").addClass("layui-icon-face-cry").removeClass("layui-icon-face-smile").css({"display":"inline","color":"red"});
        $('#regist-email-msg').html("请输入正确邮箱格式").css({"color":"red"});
        flag=false;
    }
    else {
        $("#regist-icon-3").addClass("layui-icon-face-smile").removeClass("layui-icon-face-cry").css({"color":"green"});
        $('#regist-email-msg').html("ok").css({"color":"green"});
        flag=true;
    }
    return flag;
}

function register(){
    // var flg=false;

    layui.use('layer',function () {
        var user={
            "username":$("#regist-username").val(),
            "password":$("#regist-password").val(),
            "email":$("#email").val(),
            "code":$("#code").val()
        };
        if (checkUsername()===false){
        }
        else if (checkPassword()===false){
        }
        else if (checkEmail()===false){
        }
        else {
            var index=layer.load();
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
                        layer.close(index);
                        layer.alert(data.msg,{icon:5});
                    }
                }
            });
        }

    })
}

function sendCode() {
    layui.use("layer", function () {
        var username = $("#regist-username").val();
        if (checkUsername()===false){
            $("#regist-icon").css({"display":"inline"});
            $('#regist-username-msg').html("请输入正确手机号").css({"color":"red"});
            flag=false;
        }
        else {
            var index=layer.load();
            $.ajax({
                url: "../user/sendVerifyCode.do",
                type:"post",
                data: {"username": username},
                error: function () {
                    layer.close(index);
                    layer.msg("发送失败");
                },
                success: function (data) {
                    layer.close(index);
                    if (data.status === 0){
                        var time = 60;
                        function setTime() {
                            if (time=== 0) {
                                $("#send-code").prop('disabled', false).text("点击获取验证码");
                                time = 60;//60秒过后button上的文字初始化,计时器初始化;
                            } else {
                                $("#send-code").prop('disabled', true).text("("+time+"s)后重新发送");
                                time--;
                            }
                        }
                        setTimeout(function() { setTime() },1000) //每1000毫秒执行一次
                    }
                    else {
                        alert(data.msg);
                    }
                }
            })
        }
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
        success:function () {
          window.location.href="../login.jsp";
        }
    })
}

function updateUserInfo() {
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

function allFocusMsg(i) {
    layui.use(['layer','element'],function () {
        var layer=layui.layer;
        var element=layui.element;
        var code=$("#label1"+i).text();
        $.ajax({
            url:"../msg/allMsgByCode.do",
            type:"POST",
            data:{"code":code},
            error:function () {
                alert("error");
            },
            success:function (data) {
                $("#focus-msg-list").empty();
                document.getElementById("focus-subject-tishi").style.display="none";
                $.each(data.data,function (i,item) {
                    $("#focus-msg-list").append(
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
                layer.alert("error");
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
        $("#common-title").html("发布的主题");
        $.ajax({
            url:"../subject/allSendSubject.do",
            type:"POST",
            async: false,
            error:function () {
                layer.close(index);
                layer.alert("error");
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

function allFocusSubject() {
    layui.use('layer',function () {
        var index=layer.load();
        $("#common-title").html("关注的主题");
        $.ajax({
            url:"../getSubject/allFocusSubject.do",
            type:"POST",
            async: false,
            error:function () {
                layer.close(index);
                layer.alert("error");
            },
            success:function (data) {
                layer.close(index);
                $.each(data.data,function (i,item) {
                    $("#focusSubject-list").append(
                        "<li class=\"layui-timeline-item\">"+
                        "<div class=\"layui-timeline-content layui-text\" >"
                        +"<div  onclick=\"allFocusMsg("+i+")\" class=\"layui-collapse\" lay-accordion>"
                        +"<h2  class=\"layui-colla-title\">"
                        +"<i class=\"layui-icon layui-icon-template-1 subject-icon\" style=\"color: #ff3683;font-size: 25px\"></i>"
                        +"<label class=\"subject-title\">"+item.subtitle+"</label>"
                        +"<label style=\"display: none\" id=\"label1"+i+"\"  class=\"subject-code\">"+item.code+"</label>"
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

