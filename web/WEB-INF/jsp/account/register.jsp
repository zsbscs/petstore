<%--
  Created by IntelliJ IDEA.
  User: 曾帅
  Date: 2023/11/8
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/top.jsp"%>

<html>
<head>


</head>
<body>
<div id="Main" style="text-align: center">
<form name="register" method="post">

    <div  name="feedback" style="text-align: center;color: red"></div>
   UserName: <input type="text" name="username"><br><br><br>
    password: <input type="password" name="password"><br><br><br>

            <input type="submit" value="register" align="center">
</form>



    </div>
<script src="../../../js/check_user.js"></script>
</body>
</html>
<%@include file="../common/bottom.jsp"%>