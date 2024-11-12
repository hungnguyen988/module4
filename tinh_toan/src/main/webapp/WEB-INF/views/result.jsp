<%--
  Created by IntelliJ IDEA.
  User: LENOVO LOQ
  Date: 11/12/2024
  Time: 8:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>KẾT QUẢ</h1>

<c:choose>
  <c:when test="${message != null}">
    <p>${message}</p>
  </c:when>
  <c:otherwise>
    <p>Phép toán ${num1} ${operator} ${num2}</p>
    <p>Đáp án: ${result}</p>
  </c:otherwise>
</c:choose>

</body>
</html>

