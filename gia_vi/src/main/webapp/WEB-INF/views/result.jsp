
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Gia vị bạn đã chọn:</p>
<ul>
    <c:forEach items="${condiments}" var="condiment">
        <li>${condiment}</li>
    </c:forEach>
</ul>
</body>
</html>
