<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<html>
<body>
<h1>City ${city.name}</h1>
<form:form method="post" modelAttribute="city">
    <input type="hidden" name="_method" value="patch">
    <fieldset>
        <div>
            <label for="name">Name</label>
            <form:input id="name" path="name"/>
            <form:errors path="name"/>
            <label for="countryCode">Country code</label>
            <form:input id="countryCode" path="countryCode"/>
            <form:errors path="countryCode"/>
            <label for="district">District</label>
            <form:input id="district" path="district"/>
            <form:errors path="district"/>
            <label for="population">Population</label>
            <form:input id="population" path="population"/>
            <form:errors path="population"/>
            <s:authorize access="hasRole('ROLE_USER')">
                <input type="submit" value="submit">
            </s:authorize>
        </div>
    </fieldset>
</form:form>
</body>
</html>
