<%--
  Created by IntelliJ IDEA.
  User: 曾帅
  Date: 2023/11/13
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/top.jsp"%>



<html>

<body>
<c:if test="${requestScope.signOnMsg != null}">
    <p> <font color="red">${requestScope.signOnMsg} </font> </p>
</c:if>
<div id="Catalog" align="center" style="text-align:center;vertical-align:middle;">
<form action="" method="post">

Userid:
        <input  name="userid" value="${sessionScope.loginAccount.getUsername()}"style="text-align: center"><br>


Lastname:<input name="lastname" value="${sessionScope.loginAccount.getLastName()}"> <br>Firstname:<input name="firstname"
value="${sessionScope.loginAccount.getFirstName()}"><br>
Email:<input name="email" value="${sessionScope.loginAccount.getEmail()}"><br>
        Address1:<input name="address1" value="${sessionScope.loginAccount.getAddress1()}"><br>
        Address2:<input name="address2" value="${sessionScope.loginAccount.getAddress2()}"><br>
        City:<input name="city" value="${sessionScope.loginAccount.getCity()}"><br>State:<input name="state" value="${sessionScope.loginAccount.getState()}"><br>
        Country:<input name="country" value="${sessionScope.loginAccount.getCountry()}"><br>
        PhoneNumber:<input name="phone" value="${sessionScope.loginAccount.getPhone()}"><br>
      <input type="submit" value="submit">

</form>
</div>

</body>
</html>
<%@ include file="../common/bottom.jsp"%>