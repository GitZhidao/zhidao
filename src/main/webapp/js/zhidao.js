// function regist(){
//     var user=new Object();
//     user.username=$("#username").val();
//     user.password=$("#password").val();
//     user.email=$("#email").val();
//     $.ajax({
//         url:"../user/regist.do",
//         type:"POST",
//         data:JSON.stringify(user),
//         contentType:"application/json",
//         async: true,
//         error:function(){
//             alert("注册失败")
//         },
//         success:function (data) {
//             if (data.status==0){
//                 alert("注册成功");
//             }
//             else
//             {
//                 alert(data.msg);
//             }
//         }
//     });
// }

function login(){
    var username=$("#username").val();
    var password=$("#password").val();
    $.ajax({
        url:"../user/login.do",
        type:"POST",
        data:{"username":username,"password":password},
        contentType:"application/json",
        async: true,
        error:function(){
            alert("登录失败")
        },
        success:function (data) {
            if (data.status==0){
                alert("登录成功");
            }
            else
            {
                alert(data.msg);
            }
        }
    });
}


