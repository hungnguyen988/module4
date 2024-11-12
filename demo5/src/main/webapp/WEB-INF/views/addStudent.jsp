<%--
  Created by IntelliJ IDEA.
  User: LENOVO LOQ
  Date: 11/8/2024
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>thêm mới học sinh</h1>
<form action="/saveStudent" method="post">
  <label for="id">Id:</label>
  <input type="number" id="id" name="id"><br><br>
  <label for="name">Tên học sinh:</label>
  <input type="text" id="name" name="name"><br><br>
  <input type="submit" value="Thêm mới">
  <input type="reset" value="Reset">
</form>
</form>
</body>
</html>
