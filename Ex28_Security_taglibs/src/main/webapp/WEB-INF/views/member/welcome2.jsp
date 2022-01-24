<%--
  Created by IntelliJ IDEA.
  User: Kms
  Date: 2022-01-19
  Time: 오후 3:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
    welcome : Member

    <hr>

    <%-- <c:if test="${not empty pageContext.request.userPrincipal }">
        <p> is Log-In </p>
    </c:if>

    <c:if test="${empty pageContext.request.userPrincipal }">
        <p> is Log-Out </p>
    </c:if> --%>

    <sec:authorize access="isAuthenticated()">
        <p> Log-In </p>
    </sec:authorize>

    <sec:authorize access="!isAuthenticated()">
        <p> Log-Out </p>
    </sec:authorize>

<%-- USER ID : ${pageContext.request.userPrincipal.name} <br /> --%>
    USER ID : <sec:authentication property="name"/> <br />

    <c:url value="/logout" var="logoutUrl" />
    <a href="/logout"> Log Out </a> <br />

</body>
</html>