<%--
  Created by IntelliJ IDEA.
  User: Ваня
  Date: 31.08.2018
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Flats</title>
</head>
<body>
    <h3>Add Flat</h3>
    <form action="/add" method="post">
        District <input type="text" name="district"><br>
        Address <input type="text" name="address"><br>
        Area <input type="number" name="area"><br>
        Number of rooms <input type="number" name="numOfRoom"><br>
        Price <input type="number" name="price"><br>
        <input type="submit"><br>
    </form><br>
    <a href="http://localhost:8080/clear" >clear db</a>
    <h3>Find Flat</h3>
    <form action="/results" method="get">
        District <input type="text" name="district"><br>
        Address <input type="text" name="address"><br>
        Area From <input type="number" name="areaFrom"> Area To <input type="number" name="areaTo"><br>
        Number of room <input type="number" name="numOfRoom"><br>
        Price From <input type="number" name="priceFrom"> Price To <input type="number" name="priceTo"><br>
        <input type="submit">
    </form>

</body>
</html>
