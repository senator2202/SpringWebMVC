<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<table border="1">
    <c:forEach var="city" items="${cities}">
        <tr>
            <td>${city.id}</td>
            <td>${city.name}</td>
            <td>${city.countryCode}</td>
            <td>${city.district}</td>
            <td>${city.population}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
