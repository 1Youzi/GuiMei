<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath() %>/"/>
    <%@include file="layUI.jsp" %>
    <style>
        .personWarp {
            height: 100%;
            width: 75%;
            overflow: hidden;
            margin: auto;
            background-color: #ffffff;
            padding-left: 25%;
            font-size: 16px;
            color: #696969;
        }

        input[type='text'] {
            border-radius: 5px;
            height: 40px;
            font-size: 15px;
            padding-left: 10px;
        }

        input[name='stuId'] {
            background-color: #999999;
        }

        input[type='submit'] {
            width: 225px;
        }
    </style>
</head>
<body>
<div class="personWarp">
    <form action="doadmin?action=queryById" method="post">
        <label>单号:</label>
        <input type="text" name="id" value="${sessionScope.Customer.id}" readonly/><br>
        <label>姓名:</label>
        <input type="text" name="name" value="${sessionScope.Customer.cusName}"/><br>
        <label>昵称:</label>
        <input type="text" name="loginName" value="${sessionScope.Customer.cusLoginName}"/><br>
        <label>性别:</label>
        <input type="radio" name="sex" value="男" ${sessionScope.Customer.cusSex=='男'?'checked':''} />男
        <input type="radio" name="sex" value="女" ${sessionScope.Customer.cusSex=='女'?'checked':''}/>女<br>
        <label>邮箱:</label>
        <input type="text" name="email" value="${sessionScope.Customer.cusEmail}"/><br>
        <%--<label>头像:</label>
        <input type="text" name="cusPhoto" value="${cou.cusPhoto}"/><br>--%>
        <label>证号:</label>
        <input type="text" name="code" value="${sessionScope.Customer.cusCode}"/><br>
        <label>爱好:</label>
        <input type="text" name="hobby" value="${sessionScope.Customer.cusHobby}"/><br>
        <label>生日:</label>
        <input type="date" name="birth" value="${sessionScope.Customer.cusBirthday}"/><br>
        <label>密码:</label>
        <input type="text" name="pwd" value="${sessionScope.Customer.cusPassword}"/><br>
        <input class="layui-btn layui-btn-lg" type="submit" value="保存资料"/>
    </form>
</div>

</body>
</html>
