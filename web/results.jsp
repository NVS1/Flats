<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Results</title>
</head>
<body>
    <h2>Results for your request</h2>
    <c:forEach items="${flats}" var="flat">
        <tr>
            <td> District: <c:out value="${flat.district}" /><br></td>
            <td> Address: <c:out value="${flat.address}" /><br></td>
            <td> Area: <c:out value="${flat.area}" /><br></td>
            <td> Number of Room: <c:out value="${flat.numOfRoom}" /><br></td>
            <td> Price: <c:out value="${flat.price}" /><br></td><br>
        </tr>
    </c:forEach>
</body>
</html>
