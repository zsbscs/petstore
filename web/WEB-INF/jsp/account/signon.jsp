<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="java.awt.*" %>
<%@ page import="java.util.Random" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="java.awt.*, java.awt.image.BufferedImage, javax.imageio.ImageIO, java.util.Random" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/top.jsp"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" +request.getServerPort() + path;
%>

<html>

<div id="Main" style="text-align: center">
    <form action="signOn" method="post">
        <p>Please enter your username and password.</p>
        <c:if test="${requestScope.signOnMsg != null}">
            <p> <font color="red">${requestScope.signOnMsg} </font> </p>
        </c:if>
        <p>
            Username:<input type="text" name="username"> <br>
            Password:<input type="password" name="password"><br>
        <div>
            <p>Please enter the verification code:</p>
            <img src="captchaImage" alt="captcha image" />
            <input type="text" name="verify">
        </div>



        <br>




        </p>


        <input type="submit" value="Login">





    </form>
    Need a user name and password?
    <a href="registerForm">




        Register Now!</a>

</div>

<%@ include file="../common/bottom.jsp"%>
</html>
