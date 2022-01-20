<%--
  Created by IntelliJ IDEA.
  User: Kms
  Date: 2022-01-10
  Time: 오후 2:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Insert title here</title>
</head>
<body>
<%
    out.println("Model(sub) : Hello World");
%>
<br>

${ObjectTest}

<br>

${lists}

<br>
<br>

<c:forEach var="mylist" items="${lists}">
    ${mylist} <br>
</c:forEach>

<br>
<br>

당신의 이름은 ${name} 입니다.


</body>
</html>
