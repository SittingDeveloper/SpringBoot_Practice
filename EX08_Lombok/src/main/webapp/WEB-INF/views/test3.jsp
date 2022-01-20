<%--
  Created by IntelliJ IDEA.
  User: Kms
  Date: 2022-01-11
  Time: 오후 2:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
</head>
<body>
<%
    out.println("#03 : Hello World");
%>
<br>
당신의 아이디는 ${member.id}
당신의 이름은 ${member.name}
</body>
</html>
