<%--
  Created by IntelliJ IDEA.
  User: Kms
  Date: 2022-01-19
  Time: 오후 3:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
welcome : Admin

<hr>

<c:if test="${not empty pageContext.request.userPrincipal }">
    <p> is Log-In </p>
</c:if>

<c:if test="${empty pageContext.request.userPrincipal }">
    <p> is Log-Out </p>
</c:if>

USER ID : ${pageContext.request.userPrincipal.name} <br />
<a href="/logout"> Log Out </a> <br />

</body>
</html>