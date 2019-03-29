function regist(){
    var user=new Object();
    user.username=$("#username").val();
    user.password=$("#password").val();
    user.email=$("#email").val();
    $.ajax({
        url:"../user/regist.do",
        type:"POST",
        data:JSON.stringify(user),
        contentType:"application/json",
        async: true,
        error:function(){
            alert("注册失败")
        },
        success:function (data) {
            if (data.status==0){
                alert("注册成功");
                window.location.href="/view/login.jsp"
            }
            else
            {
                alert(data.msg);
            }
        }
    });
}

function login(){
    var user=new Object();
    user.username=$("#username").val();
    user.password=$("#password").val();
    $.ajax({
        url:"../user/login.do",
        type:"POST",
        data:JSON.stringify(user),
        contentType:"application/json",
        async: true,
        error:function(){
            alert("登录失败")
        },
        success:function (data) {
            if (data.status==0){
                window.location.href='/view/main.jsp';
            }
            else {
                alert(data.msg);
            }
        }
    });
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

function findUserInfo() {
    $.ajax({
        type:"post",
        url:"../user/get_user_info.do",
        contentType:"application/json",
        error:function () {
            alert("查询失败")
        },
        success:function (date) {
          alert(data.data);
        }
    })
}

function updateUserInfo() {
    $.ajax({
        type:"post",
        url:"../user/upda.do",
        contentType:"application/json",
        error:function () {
            alert("查询失败")
        },
        success:function (date) {
            alert(data.data);
        }
    })
}