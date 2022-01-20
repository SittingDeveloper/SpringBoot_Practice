<%--
  Created by IntelliJ IDEA.
  User: Kms
  Date: 2022-01-13
  Time: 오후 2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" charset="UTF-8" content="text/html"/>
    <title>Insert title here</title>
</head>
<body>
<%
    out.println("MyBatis : Hello World!");
%>

<br>

<c:forEach var="dto" items="${users}">
    ${dto.id} / ${dto.name} <br>
</c:forEach>

</body>
</html>
