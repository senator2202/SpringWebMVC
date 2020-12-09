<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>City ${city.name}</h1>
<form method="post">
    <input type="hidden" name="_method" value="patch">
    <fieldset>
        <div>
            <label for="name">Name</label>
            <input type="text" name="name" value="${city.name}" id="name">
            <label for="countryCode">Country code</label>
            <input type="text" name="countryCode" value="${city.countryCode}" id="countryCode">
            <label for="district">District</label>
            <input type="text" name="district" value="${city.district}" id="district">
            <label for="population">Population</label>
            <input type="text" name="population" value="${city.population}" id="population">
            <input type="submit" value="submit">
        </div>
    </fieldset>
</form>
</body>
</html>
