<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Settings</title>
</head>
<body>
<h1>Settings</h1>


<form:form modelAttribute="setting" action="/update" method="post">
  <label for="language">Languages:</label>
  <form:select path="language" id="language">
    <form:option value="English" label="English" />
    <form:option value="Vietnamese" label="Vietnamese" />
    <form:option value="Japanese" label="Japanese" />
    <form:option value="Chinese" label="Chinese" />
  </form:select><br>
  <label for="pageSize">Page Size:</label>
  <form:select path="pageSize" id="pageSize">
    <form:option value="5">5</form:option>
    <form:option value="10">10</form:option>
    <form:option value="15">15</form:option>
    <form:option value="25">25</form:option>
    <form:option value="50">50</form:option>
    <form:option value="100">100</form:option>
  </form:select><br>
  <label for="spamFilterEnabled">Spams filter:</label>
  <form:checkbox path="spamFilterEnabled" id="spamFilterEnabled"/> Enable spams filter<br>
  <label for="signature">Signature:</label>
  <form:textarea path="signature" id="signature" rows="4" cols="30" /><br>
  <button type="submit">Update</button>
  <button type="reset">Cancel</button>
</form:form>
<c:if test="${!empty message}">
  <p>${message}</p>
</c:if>
</body>
</html>
