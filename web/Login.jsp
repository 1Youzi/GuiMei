<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/12/27
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>贵美登录</title>
    <link rel="stylesheet" href="css/login.css" type="text/css">
    <script src="JS/jquery-2.1.1.min.js"></script>
    <script>
        $(function () {
            $(".login2").click(function () {
                var user = $(".userName").val();
                var pwd = $(".userPwd").val();
                if (user == "") {
                    $(".userName").attr("placeholder", "账号不允许为空")
                }
                if (pwd == "") {
                    $(".userPwd").attr("placeholder", "密码不允许为空")
                }
                var b = false;
                var radios = document.getElementsByName("a");
                for (var i = 0; i < radios.length; i++) {
                    if (radios[i].checked == true) {
                        i++;
                        b = true;
                    }
                }
                if (!b) {
                    $(".pdrad").html("请选择身份登录！")
                } else {
                    $(".pdrad").html("")
                }
            })
        })
    </script>
</head>
<body>
<div>
    <form action="doadmin?action=UserLogin" method="post">
        <img class="login1" src="imge/login2.PNG">
        <img class="login2" src="imge/login-botton.PNG">
        <input type="text" class="userName" name="AdminName" value="123456789" placeholder="请输入账号：">
        <input type="password" class="userPwd" name="AdminPwd" value="123456789" placeholder="请输入密码：">
        <label><input class="rad" type="radio" name="a"/>管理员<input class="rad" type="radio" name="a"/>商家</label>
        <input type="submit" class="x"/>
    </form>

</div>
</body>
</html>
