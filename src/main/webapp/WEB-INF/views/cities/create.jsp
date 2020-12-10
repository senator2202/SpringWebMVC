<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
<h1>Add city</h1>
<form:form method="post" action="/cities/add" modelAttribute="newCity">
    <table border="1">
        <tr>
            <td>
                <form:label path="name">Name</form:label>
            </td>
            <td>
                <form:input path="name"/>
                <form:errors path="name" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="countryCode">Country code</form:label>
            </td>
            <td>
                <form:input path="countryCode"/>
                <form:errors path="countryCode" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="district">District</form:label>
            </td>
            <td>
                <form:input path="district"/>
                <form:errors path="district" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="population">Population</form:label>
            </td>
            <td>
                <form:input path="population"/>
                <form:errors path="population" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <input type="submit" value="submit">
        </tr>
    </table>
</form:form>
</body>
</html>
