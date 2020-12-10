<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<html>
<body>
<div id="userinfo">
    <s:authorize access="isAuthenticated()">
        Привет, <s:authentication property="principal.username"/>
        <br/>
        <a href="/j_spring_security_logout">Выход</a>
    </s:authorize>
</div>
<s:authorize access="isAnonymous()">
    <form id="login" name="loginForm" action="/j_spring_security_check" method="post">
        <label>Логин: </label>
        <input type="text" name="j_username">
        <label>Пароль</label>
        <input type="password" name="j_password">
        <input type="submit" name="submit" value="Войти">
    </form>
</s:authorize>

<s:authorize access="hasAnyRole('ROLE_USER')">
    <a href="${pageContext.request.contextPath}/cities/add">Add city</a>
</s:authorize>

<table border="1">
    <c:forEach var="city" items="${cities}">
        <tr>
            <td>${city.id}</td>
            <td>${city.name}</td>
            <td>${city.countryCode}</td>
            <td>${city.district}</td>
            <td>${city.population}</td>
            <s:authorize access="hasAnyRole('ROLE_USER')">
                <td>
                    <a href="/cities/${city.id}/update">update</a>
                </td>
                <td>
                    <a href="/cities/${city.id}/delete">delete</a>
                </td>
            </s:authorize>

        </tr>
    </c:forEach>
</table>
</body>
</html>
