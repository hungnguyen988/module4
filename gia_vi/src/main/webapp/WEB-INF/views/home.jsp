<%--
  Created by IntelliJ IDEA.
  User: LENOVO LOQ
  Date: 11/12/2024
  Time: 8:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>DANH SÁCH GIA VỊ</h1>
<form action="save" method="post">
  <label><input type="checkbox" name="condiment" value="Sprouts"> Sprouts</label>
  <label><input type="checkbox" name="condiment" value="Mustard"> Mustard</label>
  <label><input type="checkbox" name="condiment" value="Lettuce"> Lettuce</label>
  <label><input type="checkbox" name="condiment" value="Tomato"> Tomato</label><br>
  <button type="submit">Save</button>
</form>
</body>
</html>
