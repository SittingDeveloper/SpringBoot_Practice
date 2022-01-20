<%--
  Created by IntelliJ IDEA.
  User: Kms
  Date: 2022-01-12
  Time: 오후 4:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" ; charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

내용보기 <br>
<hr>
작성자 : ${dto.writer} <br>
제목 : ${dto.title} <br>
내용 : ${dto.content}
<hr>

<br> <p>
    <a href="list">목록보기</a>

</body>
</html>
