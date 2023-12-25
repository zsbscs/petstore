<%--
  Created by IntelliJ IDEA.
  User: 曾帅
  Date: 2023/12/25
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/top.jsp"%>
<html>
<div id="Main">
<head>
    <title>SearchResult</title>
</head>


<body>
<table>
  <tr>
    <th>Product ID</th>
    <th>Name</th>
  </tr>
  <c:forEach var="product" items="${sessionScope.products}">
    <tr>
      <td>
        <a href="productForm?productId=${product.productId}">${product.productId}</a>
      </td>
      <td>${product.name}</td>
    </tr>
  </c:forEach>
</table>



</body>
</div>
</html>
<%@include file="../common/bottom.jsp"%>