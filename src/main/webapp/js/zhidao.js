window.onload=function (ev) {
    layui.use('element',function () {
        var element = layui.element;
        var isShow = true;
    });
    $('.kit-side-fold').click(function() {
        //选择出所有的span，并判断是不是hidden
        $('.layui-nav-item span').each(function () {
            if ($(this).is(':hidden')) {
                $(this).show();
            } else {
                $(this).hide();
            }
        })
    });
    if(isShow){
        $('dd span').each(function(){
            $(this).hide();
        });
        //修改标志位
        isShow =false;
    }else{
        $('dd span').each(function(){
            $(this).show();
        });
        isShow =true;
    }
};

function register(){
    layui.use('layer',function () {
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
                layer.alert("注册失败")
            },
            success:function (data) {
                if (data.status===0){
                    layer.alert("注册成功");
                    window.location.href="/view/login.jsp"
                }
                else
                {
                    layer.alert(data.msg);
                }
            }
        });
    })
}

function login(){
    layui.use('layer',function () {
        var layer=layui.layer;
        var index=layer.load(0);
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
                layer.msg("登录失败")
            },
            success:(function (data) {
                layer.close(index);
                if (data.status===0){
                    window.location.href='/view/main.jsp';
                }
                else {
                    layer.alert(data.msg, {icon: 6});
                }
            })
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
          window.location.href="/view/login.jsp";
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
                layer.alert("用户需要登录");
                window.location.href="/view/login.jsp";

            }
            if (date.status===0)
            {
                window.location.href="/view/login.jsp"
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
}

function addMsg() {
    var msg={
        "title":$("#title").val(),
        "content":$("#content").val(),
        "location":$("#location").val(),
        "endtime":$("#endtime").val()
    };
    $.ajax({
        url:"/msg/sendMsg.do",
        method:"POST",
        
    })
}