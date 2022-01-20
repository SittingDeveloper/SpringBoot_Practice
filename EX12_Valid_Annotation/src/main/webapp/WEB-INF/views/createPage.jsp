<%--
  Created by IntelliJ IDEA.
  User: Kms
  Date: 2022-01-11
  Time: 오후 3:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
    <title>CreatePage</title>
</head>
<body>
createPage.jsp
<br />

<%
    String conPath = request.getContextPath();
%>

<form action="<%=conPath%>/create">
    작성자 : <input type="text" name="writer" value="${dto.writer}"> <br />
    내용 : <input type="text" name="content" value="${dto.content}"> <br />
    <input type="submit" value="전송"> <br />
</form>

</body>
</html>
