<%--
  Created by IntelliJ IDEA.
  User: 20885
  Date: 2018/12/27
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查看顾客</title>
    <base href="<%=request.getContextPath() %>/"/>
    <%@include file="layUI.jsp" %>
    <style>
        input {
            border-radius: 5px;
            height: 30px;
            font-size: 15px;
            padding-left: 5px;
        }
    </style>
</head>
<body>
<form action="doadmin?action=FuzzyQuery&pageNumber=1" method="post">
    <label>id:</label>
    <input type="text" name="userid" placeholder="请输入id" value="${requestScope.userid}"/>
    <label>姓名:</label>
    <input type="text" name="username" placeholder="请输入姓名" value="${requestScope.username}"/>
    <label>性别:</label>
    <select name="usersex" value="${requestScope.usersex}">
        <option value="">请选择</option>
        <option value="男">男</option>
        <option value="女">女</option>
    </select>
    <input class="layui-btn " type="submit" value="查询"/>
</form>
<c:choose>
    <c:when test="${not empty sessionScope.page.pageData}">
        <% request.setCharacterEncoding("UTF-8");%>
        <table class="layui-table" width="80%">
            <thead>
            <tr>
                <th>头像</th>
                <th>id</th>
                <th>姓名</th>
                <th>登录名</th>
                <th>邮箱</th>
                <th>性别</th>
                <th>爱好</th>
                <th>账号</th>
                <th>生日</th>

                <th colspan="2">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope.page.pageData}" var="cou">
                <tr>
                    <td><img src="${cou.cusPhoto}"></td>
                    <td>${cou.id}</td>
                    <td>${cou.cusName} </td>
                    <td>${cou.cusLoginName}</td>
                    <td>${cou.cusEmail}</td>
                    <td>${cou.cusSex}</td>
                    <td>${cou.cusHobby}</td>
                    <td>${cou.cusCode}</td>
                    <td>${cou.cusBirthday}</td>
                    <td><a class="layui-btn" href="doadmin?action=delUser&id=${cou.id}">删除</a></td>
                    <td><a class="layui-btn" href="doadmin?action=queryById&id=${cou.id}">修改</a></td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
            <tr>
                <td colspan="4">
                    第<b>${sessionScope.page.pageNumber}</b>页&nbsp;&nbsp;
                    <a class="layui-btn" href="doadmin?action=unionQuery&pageNumber=1">首页</a>
                        <%--&Id=${requestScope.id}&cusName=${requestScope.cusName}">首页</a>--%>
                    <a class="layui-btn"
                       href="doadmin?action=unionQuery&pageNumber=${sessionScope.page.pageNumber-1>0?page.pageNumber-1:1}">上一页</a>
                    <a class="layui-btn"
                       href="doadmin?action=unionQuery&pageNumber=${sessionScope.page.pageNumber+1>page.totalPage?page.totalPage:page.pageNumber+1}">下一页</a>
                    <a class="layui-btn"
                       href="doadmin?action=unionQuery&pageNumber=${sessionScope.page.totalPage}">尾页</a>
                    &nbsp;&nbsp;共<b>${sessionScope.page.totalPage}</b>页 &nbsp;&nbsp;
                    <select id="jumpNumber">
                        <c:forEach begin="1" varStatus="num" end="${sessionScope.page.totalPage}">
                            <option value="${num.count}">-${num.count}页-</option>
                        </c:forEach>
                    </select>
                    &nbsp;&nbsp;
                    <b class="layui-btn" onclick="jump()">跳转</b>

                </td>
            </tr>
            </tfoot>

        </table>
        <script>
            document.getElementsByTagName("option")[${sessionScope.page.pageNumber-1}].selected = true;

            function jump() {
                var number = document.getElementById("jumpNumber").value;
                // open("doTea?action=queryAll&pageNumber="+number,"iframe_context");
                location = "doadmin?action=unionQuery&pageNumber=" + number;
            }
        </script>
    </c:when>
    <c:otherwise>
        <h2>暂无顾客数据</h2>
    </c:otherwise>
</c:choose>

</body>
</html>
