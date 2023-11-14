<%--
  Created by IntelliJ IDEA.
  User: 曾帅
  Date: 2023/11/13
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/top.jsp"%>

</style>
<html>
<head>
    <title>User Profile</title>

</head>
<body>
<c:if test="${requestScope.signOnMsg != null}">
    <p> <font color="red">${requestScope.signOnMsg} </font> </p>
</c:if>
<p>
<form action="" method="post">
    <div align="center">
    <div style="text-align:center;vertical-align:middle;">

Userid:<input name="=userid" value="${sessionScope.username}"style="text-align: center"><br>
Password:<input name="pwd" value="${sessionScope.password}"type="password"><br>
Lastname:<input name="lastname"> <br>Firstname:<input name="firstname"><br>
Email:<input name="email"><br>
        Address1:<input nama="address1"><br>
        Address2:<input name="address2"><br>
        City:<input name="city"><br>State:<input name="state"><br>
        Country:<input name="country"><br>
        PhoneNumber:<input name="phone"><br>
      <input type="submit" value="submit">





    </div>
    </div>



</form>
</p>

</body>
</html>
<%@ include file="../common/bottom.jsp"%>