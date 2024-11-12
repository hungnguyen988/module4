<%--
  Created by IntelliJ IDEA.
  User: LENOVO LOQ
  Date: 11/12/2024
  Time: 8:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>TÍNH TOÁN CƠ BẢN</h1>
<form action="calculate" method="post">
    <label for="num1">Số thứ nhất:</label>
    <input type="text" id="num1" name="num1" required><br><br>
    <label for="num2">Số thứ hai:</label>
    <input type="text" id="num2" name="num2" required><br><br>
    <label for="operation">Tính toán:</label>
    <select id="operation" name="operation" required>
        <option value="+">Cộng</option>
        <option value="-">Trừ</option>
        <option value="*">Nhân</option>
        <option value="/">Chia</option>
    </select><br><br>
    <button type="submit">Tính toán</button>
</form>
</body>
</html>
