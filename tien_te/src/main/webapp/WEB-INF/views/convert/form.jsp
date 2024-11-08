<%--
  Created by IntelliJ IDEA.
  User: LENOVO LOQ
  Date: 11/8/2024
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Chuyển đổi từ USD sang VNĐ</h2>
<form action="convert" method="post">
    <label for="rate">Tỉ giá:</label>
    <input type="text" id="rate" name="rate" required><br><br>

    <label for="usd">USD:</label>
    <input type="text" id="usd" name="usd" required><br><br>

    <button type="submit">Chuyển đổi</button>
</form>
</body>
</html>
