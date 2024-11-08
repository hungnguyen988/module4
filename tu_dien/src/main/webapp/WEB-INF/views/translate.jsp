
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Kết quả tra cứu</h2>
<c:choose>
  <c:when test="${not empty meaning}">
    <p><strong>${word}:</strong> ${meaning}</p>
  </c:when>
  <c:otherwise>
    <p>${message}</p>
  </c:otherwise>
</c:choose>
</body>
</html>
